package plp.enquanto;


import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import plp.enquanto.linguagem.Linguagem.*;
import plp.enquanto.parser.EnquantoBaseListener;
import plp.enquanto.parser.EnquantoParser;
import plp.enquanto.parser.EnquantoParser.*;

public class MeuListener extends EnquantoBaseListener {
	private final Leia leia = new Leia();
	private final Skip skip = new Skip();
	private final ParseTreeProperty<Object> values = new ParseTreeProperty<>();

	private Programa programa;

	public Programa getPrograma() {
		return programa;
	}

	private void setValue(final ParseTree node, final Object value) {
		values.put(node, value);
	}

	private Object getValue(final ParseTree node) {
		return values.get(node);
	}

	@Override
	public void exitBooleano(final EnquantoParser.BooleanoContext ctx) {
		setValue(ctx, new Booleano(ctx.getText().equals("verdadeiro")));
	}

	@Override
	public void exitLeia(final EnquantoParser.LeiaContext ctx) {
		setValue(ctx, leia);
	}

	@Override
	public void exitSe(final EnquantoParser.SeContext ctx) {
		ArrayList<Comando> comandos=new ArrayList<>();
		ArrayList<Bool> bools=new ArrayList<>();
		int i=0;
		while (getValue(ctx.bool(i))!=null) {
			bools.add((Bool) getValue(ctx.bool(i)));
			comandos.add((Comando) getValue(ctx.comando(i)));
			i++;
		}
		if(getValue(ctx.comando(i))!=null)
			comandos.add((Comando) getValue(ctx.comando(i)));
		setValue(ctx, new Se(bools,comandos));
		/*final Bool condicao1 = (Bool) getValue(ctx.bool(0));
		final Comando entao1 = (Comando) getValue(ctx.comando(0));
		if((Bool) getValue(ctx.bool(1))!=null){
		final Bool condicao2 = (Bool) getValue(ctx.bool(1));	
		final Comando entao2 = (Comando) getValue(ctx.comando(1));
		final Comando senao = (Comando) getValue(ctx.comando(2));
		setValue(ctx, new Se(condicao1, entao1,condicao2, entao2, senao));}
		else {final Comando senao=(Comando) getValue(ctx.comando(1));
		setValue(ctx, new Se(condicao1, entao1, senao));}*/
	}

	@Override
	public void exitInteiro(final EnquantoParser.InteiroContext ctx) {
		setValue(ctx, new Inteiro(Integer.parseInt(ctx.getText())));
	}

	@Override
	public void exitSkip(final EnquantoParser.SkipContext ctx) {
		setValue(ctx, skip);
	}

	@Override
	public void exitEscreva(final EnquantoParser.EscrevaContext ctx) {
		final Expressao exp = (Expressao) getValue(ctx.expressao());
		setValue(ctx, new Escreva(exp));
	}

	@Override
	public void exitPrograma(final EnquantoParser.ProgramaContext ctx) {
		@SuppressWarnings("unchecked")
		final List<Comando> cmds = (List<Comando>) getValue(ctx.seqComando());
		programa = new Programa(cmds);
		setValue(ctx, programa);
	}

	@Override
	public void exitId(final EnquantoParser.IdContext ctx) {
		setValue(ctx, new Id(ctx.ID().getText()));
	}

	@Override
	public void exitSeqComando(final EnquantoParser.SeqComandoContext ctx) {
		final List<Comando> comandos = new ArrayList<>();
		for (EnquantoParser.ComandoContext c : ctx.comando()) {
			comandos.add((Comando) getValue(c));
		}
		setValue(ctx, comandos);
	}

	@Override
	public void exitAtribuicao(final EnquantoParser.AtribuicaoContext ctx) {
		final String id = ctx.ID().getText();
		final Expressao exp = (Expressao) getValue(ctx.expressao());
		setValue(ctx, new Atribuicao(id, exp));
	}

	@Override
	public void exitBloco(final EnquantoParser.BlocoContext ctx) {
		@SuppressWarnings("unchecked")
		final List<Comando> cmds = (List<Comando>) getValue(ctx.seqComando());
		setValue(ctx, new Bloco(cmds));
	}

	@Override
	public void exitOpBin(final EnquantoParser.OpBinContext ctx) {//operações soma, resta, multiplicação e divição
		final Expressao esq = (Expressao) getValue(ctx.expressao(0));
		final Expressao dir = (Expressao) getValue(ctx.expressao(1));
		final String op = ctx.getChild(1).getText();
		final ExpBin exp;
		switch (op) {
		case "+":
			exp = new ExpSoma(esq, dir);//soma linguagem.java
			break;
		case "*":
			exp = new ExpMult(esq, dir);//multiplicação linguagem.java
			break;
		case "-":
			exp = new ExpSub(esq, dir);//resta linguagem.java
			break;
                case "/":
			exp = new ExpDiv(esq, dir);//divição linguagem.java
			break;
                case "^":
        	exp = new ExpPow(esq, dir);//potencia linguagem.java
        	break;
		default:
			exp = new ExpSoma(esq, dir);//soma linguagem.java
		}
		setValue(ctx, exp);
	}

	@Override
	public void exitEnquanto(final EnquantoParser.EnquantoContext ctx) {//exit while
		final Bool condicao = (Bool) getValue(ctx.bool());
		final Comando comando = (Comando) getValue(ctx.comando());
		setValue(ctx, new Enquanto(condicao, comando));//while linguagem.java
	}

	@Override
	public void exitPara(final EnquantoParser.ParaContext ctx) {//exit while
		final String id = ctx.ID().getText();
		final Expressao x = (Expressao) getValue(ctx.expressao(0));
		final Expressao y = (Expressao) getValue(ctx.expressao(1));
		final Comando comando = (Comando) getValue(ctx.comando());
		setValue(ctx, new Para(id,x,y, comando));//FOR linguagem.java
	}
	
	@Override
	public void exitELogico(final EnquantoParser.ELogicoContext ctx) {//exit and
		final Bool esq = (Bool) getValue(ctx.bool(0));
		final Bool dir = (Bool) getValue(ctx.bool(1));
		setValue(ctx, new ELogico(esq, dir));//and linguagem.java
	}
	
	@Override
	public void exitOuLogico(final EnquantoParser.OuLogicoContext ctx) {//exit and
		final Bool esq = (Bool) getValue(ctx.bool(0));
		final Bool dir = (Bool) getValue(ctx.bool(1));
		setValue(ctx, new OULogico(esq, dir)); //ou linguagem.java
	}
	
	@Override
	public void exitXorLogico(final EnquantoParser.XorLogicoContext ctx) {//exit and
		final Bool esq = (Bool) getValue(ctx.bool(0));
		final Bool dir = (Bool) getValue(ctx.bool(1));
		setValue(ctx, new XORLogico(esq, dir));//xor linguagem.java
	}

	@Override
	public void exitBoolPar(final EnquantoParser.BoolParContext ctx) {
		setValue(ctx, getValue(ctx.bool()));
	}

	@Override
	public void exitNaoLogico(final EnquantoParser.NaoLogicoContext ctx) {// exit not
		final Bool b = (Bool) getValue(ctx.bool());
		setValue(ctx, new NaoLogico(b));//not linguagem.java
	}

	@Override
	public void exitExpPar(final EnquantoParser.ExpParContext ctx) {
		setValue(ctx, getValue(ctx.expressao()));
	}

	@Override
	public void exitExiba(final EnquantoParser.ExibaContext ctx) {//exiba
		final String t = ctx.Texto().getText();
		final String texto = t.substring(1, t.length() - 1);
		setValue(ctx, new Exiba(texto));//exiba linguagem.java
	}

	@Override
	public void exitOpRel(final EnquantoParser.OpRelContext ctx) {//operadores de relação
		final Expressao esq = (Expressao) getValue(ctx.expressao(0));
		final Expressao dir = (Expressao) getValue(ctx.expressao(1));
		final String op = ctx.getChild(1).getText();
		final ExpRel exp;
		switch (op) {
		case "=":
			exp = new ExpIgual(esq, dir);//igual linguagem.java
			break;
		case "<=":
			exp = new ExpMenorIgual(esq, dir);//menor igual linguagem.java
			break;
                case ">=":
			exp = new ExpMaiorIgual(esq, dir);//maior igual linguagem.java
			break;
                case "<>":
			exp = new ExpDiferentes(esq, dir);//Diferentes linguagem.java
			break;
		default:
			exp = new ExpIgual(esq, dir);//igual linguagem.java
		}
		setValue(ctx, exp);
	}
}
