package br.com.agrodigital.controller;

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
		//LancamentoDao dao = getDaoLancamento(a);
		//boolean resposta = dao.insert(a);
		//return resposta;
		return true;
	}
	
	public Lancamento listar(int id, String tipo) {
		// LancamentoDao dao = getDaoLancamento(a, tipo);
		// boolean resposta = dao.select(id);
		// return resposta;
		if (tipo.equals("Receita")){
			Receita r = new Receita("teste", "01/01/2020", "Receita", 10.10);
			return r;
		} else if (tipo.equals("Despesa")) {
			Despesa d = new Despesa("teste", "01/01/2020", "Despesa", 10.10, "Mão de obra");
			return d;
		}
		return null;
	}
	
	public boolean atualizar(Lancamento a) {
		// LancamentoDao dao = getDaoLancamento(a);
		// boolean resposta = dao.update(a);
		// return resposta;
		return true;
		}
	
	public boolean deletar(int id, String tipo) {
		// LancamentoDao dao = getDaoLancamento(a, tipo);
		// boolean resposta = dao.delete(id);
		// return resposta;
		return true;
	}
	
//	public LancamentoDao getDaoLancamento(Lancamento a) {
//		if(a instanceof Receita) {
//			//return new ReceitaDao(a);
//		} else if(a instanceof Despesa) {
//			// return new DespesaDao(a);
//		}
//	}
	
//	public LancamentoDao getDaoLancamento(String a) {
//	if((a.equals("Receita"))) {
//		//return new ReceitaDao(a);
//	} else if((tipo.equals("Despesa"))) {
//		// return new DespesaDao(a);
//	}
//	return null
//}

}

