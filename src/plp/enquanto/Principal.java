package plp.enquanto;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import plp.enquanto.parser.EnquantoLexer;
import plp.enquanto.parser.EnquantoParser;

import static plp.enquanto.linguagem.Linguagem.*;
import static java.util.Arrays.*;

public class Principal {

	private static ParseTree parse(String programa) {
		final ANTLRInputStream input = new ANTLRInputStream(programa);
		final EnquantoLexer lexer = new EnquantoLexer(input);
		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final EnquantoParser parser = new EnquantoParser(tokens);
		return parser.programa();
	}

	public static void main(String... args) throws IOException {
		String programa = "i:=0;"
				+ "para i de 0 ate 10 faca{"
				+ "se i=1 xor i=4 entao escreva (i^2)"
				+ " senaose i=3 ou i=5 entao escreva (i*10)/2"
				+ " senaose i=2 ou i=6 entao escreva (i*10) "
				+ "senao escreva i+10}";
		/*String programa = "i:=0; soma:=0; b:=14;"
				+ "para i de 1 ate b faca "
				+ "soma:= soma+2; "
				+ "escreva soma";*/
		final ParseTree tree = parse(programa);
		final ParseTreeWalker walker = new ParseTreeWalker();
		final MeuListener listener = new MeuListener();
		walker.walk(listener, tree);
		Programa p1 = listener.getPrograma();
		p1.execute();
		//p2.execute();
		
}
}