package plp.enquanto.linguagem;
import java.lang.Math;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import plp.enquanto.linguagem.Linguagem.Inteiro;
import plp.enquanto.parser.EnquantoParser.SeContext;

public interface Linguagem {
	final Map<String, Integer> ambiente = new HashMap<>();
	final Scanner scanner = new Scanner(System.in);
//////////////////////////////////////////////classes primitivas do lenguagem//////////////////////////////////////////////////////
	interface Bool {
		public boolean getValor();
	}

	interface Comando {
		public void execute();
	}

	interface Expressao {
		public int getValor();
	}
///////////////////////////////////////////////////////////leitor//////////////////////////////////////////////////////////////////
	Leia leia = new Leia();
	class Leia implements Expressao {
		@Override
		public int getValor() {
			return scanner.nextInt();
		}
	}
        
///////////////////////////////////////////////////////////Programa//////////////////////////////////////////////////////////////////
       
        	class Programa {
		private List<Comando> comandos;
		public Programa(List<Comando> comandos) {
			this.comandos = comandos;
		}
		public void execute() {
			for (Comando comando : comandos) {
				comando.execute();
			}
		}
	}
        
////////////////////////////////////////////////////////calculos///////////////////////////////////////////////////////////////////      
        
        abstract class ExpBin implements Expressao {//encapsula duas expressoes
		protected Expressao esq;
		protected Expressao dir;

		public ExpBin(Expressao esq, Expressao dir) {
			this.esq = esq;
			this.dir = dir;
		}
	}

	class Se implements Comando {//comando if, ao extender comando executa uma ação execute()
		private ArrayList<Comando> comandos;
		private ArrayList<Bool> bools;
		
		public Se(ArrayList<Bool> bools,ArrayList<Comando> comandos) {
		this.bools=bools;
		this.comandos=comandos;
	}
	@Override
	public void execute() {
		int i=0;
		for(Bool bool:bools){
			if(bool.getValor()){
			comandos.get(i).execute();
			return;
			}
		i++;
		}
		comandos.get(i).execute();
	}
}
	
	
	
	

	Skip skip = new Skip();
	class Skip implements Comando {
		@Override
		public void execute() {
		}
	}

	class Escreva implements Comando {
		private Expressao exp;

		public Escreva(Expressao exp) {
			this.exp = exp;
		}

		@Override
		public void execute() {
			System.out.println(exp.getValor());
		}
	}

	class Enquanto implements Comando {//while,pega condição(Bool(getValor() ))e faca(Comando(execute() ))
		private Bool condicao;
		private Comando faca;

		public Enquanto(Bool condicao, Comando faca) {
			this.condicao = condicao;
			this.faca = faca;
		}

		@Override
		public void execute() {
			while (condicao.getValor()) {
				faca.execute();
			}
		}
	}
	
	class Para implements Comando {//while,pega condição(Bool(getValor() ))e faca(Comando(execute() ))
		private String id;
		private Comando faca;
		private Expressao x1,x2;

		public Para(String id,Expressao x1,Expressao x2, Comando faca) {
			this.id = id;
			this.faca = faca;
			this.x1=x1;
			this.x2=x2;
		}

		@Override
		public void execute() {
			Integer i,j=x2.getValor();
			for(i=x1.getValor();i<=j;i++) {
				ambiente.replace(id, i);
				faca.execute();
				
			}
		}
	}

	class Exiba implements Comando {
		public Exiba(String texto) {
			this.texto = texto;
		}

		private String texto;

		@Override
		public void execute() {
			System.out.println(texto);
		}
	}

	class Bloco implements Comando {
		private List<Comando> comandos;

		public Bloco(List<Comando> comandos) {
			this.comandos = comandos;
		}

		@Override
		public void execute() {
			for (Comando comando : comandos) {
				comando.execute();
			}
		}
	}

	class Atribuicao implements Comando {//guarda variavel no map ambiente
		private String id;
		private Expressao exp;

		public Atribuicao(String id, Expressao exp) {
			this.id = id;
			this.exp = exp;
		}

		@Override
		public void execute() {
			ambiente.put(id, exp.getValor());
		}
	}

	class Inteiro implements Expressao {
		private int valor;

		public Inteiro(int valor) {
			this.valor = valor;
		}

		@Override
		public int getValor() {
			return valor;
		}
	}

	class Id implements Expressao {//busca variavel no map ambiente
		private String id;

		public Id(String id) {
			this.id = id;
		}
		public String nome(){return id;}
		@Override
		public int getValor() {
			final Integer v = ambiente.get(id);
			final int valor;
			if (v != null)
				valor = v;
			else
				valor = 0;

			return valor;
		}
	}

	

	class ExpSoma extends ExpBin {//soma
		public ExpSoma(Expressao esq, Expressao dir) {
			super(esq, dir);
		}

		@Override
		public int getValor() {
			return esq.getValor() + dir.getValor();
		}
	}

	class ExpSub extends ExpBin {//resta
		public ExpSub(Expressao esq, Expressao dir) {
			super(esq, dir);
		}

		@Override
		public int getValor() {
			return esq.getValor() - dir.getValor();
		}
	}
	
	class ExpMult extends ExpBin {//multiplicação
		public ExpMult(Expressao esq, Expressao dir) {
			super(esq, dir);
		}

		@Override
		public int getValor() {
			return esq.getValor() * dir.getValor();
		}
	}
        
        class ExpDiv extends ExpBin {//divisão
		public ExpDiv(Expressao esq, Expressao dir) {
			super(esq, dir);
		}

		@Override
		public int getValor() {
			return esq.getValor() / dir.getValor();
		}
	}
        class ExpPow extends ExpBin {//potencia
    		public ExpPow(Expressao esq, Expressao dir) {
    			super(esq, dir);
    		}

    		@Override
    		public int getValor() {
    			return (int) Math.pow(esq.getValor(),dir.getValor());
    		}
    	}
            
///////////////////////////////////////////////relações de expreções////////////////////////////////////////////////////////////////
	class Booleano implements Bool {//devolve um valor ao implementar a interface Bool
		private boolean valor;

		public Booleano(boolean valor) {
			this.valor = valor;
		}

		@Override
		public boolean getValor() {
			return valor;
		}
	}

	abstract class ExpRel implements Bool {//devolve valor,tudo que erda esta classe vai devolver uma relação com valores
		protected Expressao esq;
		protected Expressao dir;

		public ExpRel(Expressao esq, Expressao dir) {
			this.esq = esq;
			this.dir = dir;
		}
	}

	public class ExpIgual extends ExpRel {

		public ExpIgual(Expressao esq, Expressao dir) {
			super(esq, dir);
		}

		@Override
		public boolean getValor() {
			return esq.getValor() == dir.getValor();
		}

	}

	public class ExpMenorIgual extends ExpRel {
		public ExpMenorIgual(Expressao esq, Expressao dir) {
			super(esq, dir);
		}

		@Override
		public boolean getValor() {
			return esq.getValor() <= dir.getValor();
		}
	}
        
        public class ExpMaiorIgual extends ExpRel {
		public ExpMaiorIgual(Expressao esq, Expressao dir) {
			super(esq, dir);
		}

		@Override
		public boolean getValor() {
			return esq.getValor() >= dir.getValor();
		}
	}
        
        public class ExpDiferentes extends ExpRel {
		public ExpDiferentes(Expressao esq, Expressao dir) {
			super(esq, dir);
		}

		@Override
		public boolean getValor() {
			return esq.getValor() != dir.getValor();
		}
	}

	public class NaoLogico implements Bool {
		private Bool b;

		public NaoLogico(Bool b) {
			this.b = b;
		}

		@Override
		public boolean getValor() {
			return !b.getValor();
		}
	}

	public class ELogico implements Bool {
		private Bool esq;
		private Bool dir;

		public ELogico(Bool esq, Bool dir) {
			this.esq = esq;
			this.dir = dir;
		}

		@Override
		public boolean getValor() {
			return esq.getValor() && dir.getValor();
		}
	}
	
	public class XORLogico implements Bool {
		private Bool esq;
		private Bool dir;

		public XORLogico(Bool esq, Bool dir) {
			this.esq = esq;
			this.dir = dir;
		}

		@Override
		public boolean getValor() {
			return esq.getValor() ^ dir.getValor();
		}
	}
	
	public class OULogico implements Bool {
		private Bool esq;
		private Bool dir;

		public OULogico(Bool esq, Bool dir) {
			this.esq = esq;
			this.dir = dir;
		}

		@Override
		public boolean getValor() {
			return esq.getValor() || dir.getValor();
		}
	}
}
