public class Aluno implements Comparable<Aluno>
{
	private String nome;
	private int matricula;
	
	public Aluno(String n, int m)
	{
		nome = n;
		matricula = m;
	}
	
	public int compareTo(Aluno a)
	{
		if(this.matricula < a.matricula)
			return -1;
		else if(this.matricula == a.matricula)
			return 0;
		else
			return 1;
	}
}