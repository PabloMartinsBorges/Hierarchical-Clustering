import java.util.Deque;
import java.util.ArrayDeque;

public class Main
{
	public static void main(String[] args)
	{
		Arvbin<Integer> a1 = new Arvbin<Integer>(1),
				a2 = new Arvbin<Integer>(2),
				a3 = new Arvbin<Integer>(3,a1,a2),
				a4 = new Arvbin<Integer>(28),
				a5 = new Arvbin<Integer>(5),
				a6 = new Arvbin<Integer>(6),
				a7 = new Arvbin<Integer>(11,a5,a6),
				a8 = new Arvbin<Integer>(8),
				a9 = new Arvbin<Integer>(9),
				a10 = new Arvbin<Integer>(10,a8,a9);

				a4.defineEsq(a3);
				a4.defineDir(a7);
				a4.mostra();
				System.out.println();
				
				System.out.println("Número de nós: " + a4.contaNos());
				
				System.out.println("Altura da árvore: " + a4.calculaAltura());
				
				Deque<Integer> caminhos = new ArrayDeque<Integer>();
				
				a4.imprimeTodosCaminhos(caminhos);
				
				if(Arvbin.verificaArvoreSoma(a4) != Integer.MIN_VALUE)
					System.out.println("A árvore corresponde a uma árvore soma.");
				else
					System.out.println("A árvore não corresponde a uma árvore soma.");
				
				Arvbin<Integer> a11 = a4.busca(3);
				if (a11 != null)
				{
					a11.defineVal(11);
					a11.defineEsq(a10);
				}
				a4.mostra();
				System.out.println();
	}
}
