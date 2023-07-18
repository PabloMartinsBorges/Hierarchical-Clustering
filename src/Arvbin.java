import java.util.Deque;
import java.util.Iterator;

public class Arvbin<T extends Comparable<T>>
{
	private T val;   /* Valor armazenado na raiz. */

	/* Referências para subárvores. */
	private Arvbin<T> esq, dir;

	/* Construtor de árvore sem sub-ávores (dir = esq = null). É fornecido apenas o valor da raiz. */
	public Arvbin(T valor)
	{
		val = valor;
		esq = null;
		dir = null;
	}

	/* Construtor de árvore com sub-ávores. São fornecidos
	o valor da raiz e as subárvores, que devem ter sido 
	construídas previamente.*/
	public Arvbin(T valor, Arvbin<T> arvEsq, Arvbin<T> arvDir)
	{
		val = valor;
		esq = arvEsq;
		dir = arvDir;
	}

	/* Retorna o valor armazenado na raiz. */
	public T retornaVal()
	{
		return val;
	}

	/* Retorna a subárvore esquerda 
	   (ou null se não houver). */
	public Arvbin<T> retornaEsq()
	{
		return esq;
	}

	/* Retorna a subárvore direita 
    (ou null se não houver). */
	public Arvbin<T> retornaDir()
	{
		return dir;
	}

	/* Modifica o valor armazenado na raiz. */
	public void defineVal(T valor)
	{
		val = valor;
	}

	/* Redefine a subárvore esquerda, apagando a antiga se houver. */
	public void defineEsq(Arvbin<T> filho)
	{
		esq = filho;
	} 

	/* Redefine a subárvore direita, apagando a antiga se houver. */
	public void defineDir(Arvbin<T> filho)
	{
		dir = filho;
	}

	/* Imprime o conteúdo da árvore em pré-ordem */
	public void mostra()
	{
		System.out.print("(" + val);
		if (esq != null)
			esq.mostra();
		if (dir != null)
			dir.mostra();
		System.out.print(")");
	}
	
	/* Verifica se um valor está na árvore. Se estiver, retorna um ponteiro para o
	   o nó que tem esse valor. Caso contrário, retorna null. */
	public Arvbin<T> busca(T valor)
	{
		Arvbin<T> ret;

		/* Se é igual ao valor armazenado, não precisa procurar mais. O nó é a raiz. */
		if (valor.compareTo(val) == 0)
		{
			return this;
		}

		/* Senão, começa procurando na subárvore esquerda. */
		if (esq != null)
		{
			ret = esq.busca(valor);
			
			if (ret != null)
				return ret;
		}

		/* Se chega a esse ponto, estará na árvore se, e somente se, 
	     estiver na subárvore direita */
		if (dir != null) 
			return dir.busca(valor);
		
		return null;
	}
	
	/* Calcula e retorna o número de nós na árvore. */
	public int contaNos()
	{
		if((esq == null) && (dir == null))
			return 1;
		
		int nosEsq = 0, nosDir = 0;
		
		if(esq != null)
			nosEsq = esq.contaNos();
		
		if(dir != null)
			nosDir = dir.contaNos();
		
		return 1 + nosEsq + nosDir;
	}
	
	/* Calcula e retorna a altura da árvore. */
	public int calculaAltura()
	{
		if((esq == null) && (dir == null))
			return 0;
		
		int altEsq = 0, altDir = 0;
		
		if(esq != null)
			altEsq = esq.calculaAltura();
		
		if(dir != null)
			altDir = dir.calculaAltura();
		
		return 1 + Math.max(altEsq, altDir);
	}
	
	/* Calcula e retorna o maior valor contido na árvore. */
	public T calculaMaximo()
	{
		if((esq == null) && (dir == null))
			return val;
		
		T maiorFilhos, maiorEsq, maiorDir; 
		
		if((esq != null) && (dir == null))
		{
			maiorFilhos = esq.calculaMaximo();
		}
		else if((esq == null) && (dir != null))
		{
			maiorFilhos = dir.calculaMaximo();
		}
		else
		{
			maiorEsq = esq.calculaMaximo();
			maiorDir = dir.calculaMaximo();
			
			if(maiorEsq.compareTo(maiorDir) > 0)
				maiorFilhos = maiorEsq;
			else
				maiorFilhos = maiorDir;
		}
		
		if(maiorFilhos.compareTo(val) > 0)
			return maiorFilhos;
		
		return val;
	}
	
	/* Calcula a soma dos valores dos nós de uma árvore de inteiros. */
	public static int calculaSoma(Arvbin<Integer> no)
	{
		if(no == null)
			return 0;

		int acumulado = 0;
						
		acumulado += calculaSoma(no.esq);
		
		acumulado += calculaSoma(no.dir);
		
		acumulado += no.val;
		
		return acumulado;
	}
	
	/* Resolução da questão 1 disponível no moodle. */
	public int contaNosIntervalo(T min, T max)
	{
		if((esq == null) && (dir == null))
		{
			if((val.compareTo(min)) >= 0 && (val.compareTo(max) <= 0))
				return 1;
			else
				return 0;
		}
		
		int nosEsq = 0, nosDir = 0, noCont = 0;
		
		if(esq != null)
			nosEsq = esq.contaNosIntervalo(min, max);
		
		if(dir != null)
			nosDir = dir.contaNosIntervalo(min, max);
		
		if((val.compareTo(min) >= 0) && (val.compareTo(max) <= 0))
			noCont = 1;
		
		return noCont + nosEsq + nosDir;
	}
	
	/* Resolução da questão 2 disponível no moodle. */
	public static int verificaArvoreSoma(Arvbin<Integer> arvore)
	{
		/* Caso base: se é uma subárvore vazia, deve retornar 0. */
		if(arvore == null)
			return 0;
		
		/* Caso base: se é uma folha, retorna o valor contido no nó. */
		if((arvore.esq == null) && (arvore.dir == null))
			return arvore.val;
		
		/* Caso geral: deve chamar para a esquerda e para a direita, verificando
		 * a soma. */
		int somaEsquerda = 0, somaDireita = 0;
		
		if(arvore.esq != null)
			somaEsquerda = verificaArvoreSoma(arvore.esq);
		
		if(arvore.dir != null)
			somaDireita = verificaArvoreSoma(arvore.dir);
			
		/* Agora devemos verificar se o valor do nó corresponde à soma dos valores
		 * contidos nas subárvores esquerda e direita. */
		if((somaEsquerda != Integer.MIN_VALUE) && (somaDireita != Integer.MIN_VALUE)
				&& (arvore.val == somaEsquerda + somaDireita))
			return arvore.val + somaEsquerda + somaDireita;
		
		return Integer.MIN_VALUE;
	}
	
	/* Resolução da questão 3 disponível no moodle. */
	public boolean eIgual(Arvbin<T> outra)
	{
		if(this.esq == null && this.dir == null)
		{
			if(outra.esq == null && outra.dir == null)
			{
				if(this.val.compareTo(outra.val) == 0)
					return true;
				else
					return false;
			}
			else
				return false;
		}
		
		boolean esqIgual = true, dirIgual = true;
		
		if(this.esq != null)
		{
			if(outra.esq == null)
				return false;
			else
				esqIgual = this.esq.eIgual(outra.esq);
		}
		else
		{
			if(outra.esq != null)
				return false;
		}
		
		if(this.dir != null)
		{
			if(outra.dir == null)
				return false;
			else
				dirIgual = this.dir.eIgual(outra.dir);
		}
		else
		{
			if(outra.dir != null)
				return false;
		}
		
		if(this.val.compareTo(outra.val) == 0)
			return esqIgual && dirIgual;
		else
			return false;
	}
	
	/* Calcula e retorna o diâmetro da árvore, isto é, o número
	 * de nós contido no maior caminho de um nó para outro nó da
	 * árvore. */
	public int calculaDiametro()
	{
		/* Caso base, quando é uma folha. */
		if((esq == null) && (dir == null))
		{
			return 1;
		}
		
		/* Calcula a altura das subárvores esquerda e direita do nó. */
		int alturaEsq = 0, alturaDir = 0;
		
		if(esq != null)
			alturaEsq = esq.calculaAltura();
		
		if(dir != null)
			alturaDir = dir.calculaAltura();
		
		int maxDistanciaNo = alturaEsq + alturaDir + 1;
		
		/* Nesse ponto, temos a maior distância entre dois nós da árvore
		 * que passa pelo nó corrente (this). Agora devemos calcular esse
		 * valor para as subárvores esquerda e direita, comparando depois. */		
		
		int maxDistanciaEsq = 0, maxDistanciaDir = 0;
		
		if(esq != null)
			maxDistanciaEsq = esq.calculaDiametro();
		
		if(dir != null)
			maxDistanciaDir = dir.calculaDiametro();
		
		int maxDistanciaFilhos = Math.max(maxDistanciaEsq,  maxDistanciaDir);
		
		if(maxDistanciaNo > maxDistanciaFilhos)
			return maxDistanciaNo;
		else
			return maxDistanciaFilhos;
	}
	
	/* Método que realiza a impressão de todos os caminhos da raiz para uma folha. */
	public void imprimeTodosCaminhos(Deque<T> caminhos)
	{
		/* Adiciona o nó no caminho. */
		caminhos.addLast(val);

		/* Caso base: quando é uma folha. */
		if((esq == null) && (dir == null))
		{
			/* Chegou-se ao fim do caminho, portanto deve-se imprimi-lo. */
			imprimeCaminho(caminhos);
		}

		/* Caso geral: deve-se fazer a recursão para os nós esquerdo (se houver) e 
		 * para o direito (se houver). */
		
		if(esq != null)
			esq.imprimeTodosCaminhos(caminhos);

		if(dir != null)
			dir.imprimeTodosCaminhos(caminhos);
		
		/* Remove o nó corrente do caminho após as chamadas recursivas para os
		 * nós esquerdo e direito. */ 
		caminhos.removeLast();
	}

	/* Método privado auxiliar que imprime os nós contidos na estrutura caminhos. */
	private void imprimeCaminho(Deque<T> caminhos)
	{
		Iterator<T> iterator = caminhos.iterator();

		while(iterator.hasNext())
		{
			System.out.print(iterator.next() + " -> ");
		}

		System.out.println();
	}
}