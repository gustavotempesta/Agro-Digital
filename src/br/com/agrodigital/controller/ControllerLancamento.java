package br.com.agrodigital.controller;

import br.com.agrodigital.dao.DaoLancamento;
import br.com.agrodigital.model.Conta;
import br.com.agrodigital.model.Despesa;
import br.com.agrodigital.model.Lancamento;
import br.com.agrodigital.model.Receita;

public class ControllerLancamento {
	
	private static ControllerLancamento instance = null;
	
	private ControllerLancamento () {};
	
	public static ControllerLancamento getInstance() {
		if(instance == null) {
			instance = new ControllerLancamento();
		}
		return instance;
	}
	
	public boolean adicionar(Lancamento a) {
		DaoLancamento dao = new DaoLancamento();
		boolean resposta = dao.insert(a);
		if (resposta == false) {
			return resposta;
		}else {
		
			if (a.getTipo().equals("Receita")){
				Receita l = (Receita) a;
				Conta conta = ControllerConta.getInstance().listar(l.getIdConta());
				l.credita(l.getValor(), conta);
				Conta contaAtualizar = new Conta(conta.getId(), conta.getDescricao(), conta.getSaldo());
				boolean respostaAtualizar = ControllerConta.getInstance().atualizar(contaAtualizar);
				return resposta && respostaAtualizar;
			
			}else if (a.getTipo().equals("Despesa")) {
				Despesa l = (Despesa) a;
				Conta conta = ControllerConta.getInstance().listar(l.getIdConta());
				l.debita(l.getValor(), conta);
				Conta contaAtualizar = new Conta(conta.getId(), conta.getDescricao(), conta.getSaldo());
				boolean respostaAtualizar = ControllerConta.getInstance().atualizar(contaAtualizar);
				return resposta && respostaAtualizar;
			}
			
			return false;
		}

	}
	
	public Lancamento listar(int id) {
		DaoLancamento dao = new DaoLancamento();
		Lancamento resposta = dao.select(id);
		System.out.println(resposta);
		return resposta;
	}
	
	public boolean atualizar(Lancamento a) {
		DaoLancamento dao = new DaoLancamento();
		boolean resposta = dao.update(a);
		return resposta;
	}
	
	public boolean deletar(int id) {
		DaoLancamento dao = new DaoLancamento();
		boolean resposta = dao.delete(id);
		return resposta;
	}
	
//	public DaoLancamento getDaoLancamento(Lancamento a) {
//		if(a instanceof Receita) {
//			//return new ReceitaDao(a);
//		} else if(a instanceof Despesa) {
//			// return new DespesaDao(a);
//		}
//	}
	
//	public DaoLancamento getDaoLancamento(String a) {
//	if((a.equals("Receita"))) {
//		//return new ReceitaDao(a);
//	} else if((tipo.equals("Despesa"))) {
//		// return new DespesaDao(a);
//	}
//	return null
//}

}

