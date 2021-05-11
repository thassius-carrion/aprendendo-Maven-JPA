package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		//Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		//Pessoa p2 = new Pessoa(null, "Jose Henrique", "jose@gmail.com");
		//Pessoa p3 = new Pessoa(null, "Jaqueline Souza", "jaque@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		/*
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();*/ //criando p1,p2 e p3 no banco de dados
		
		Pessoa p = em.find(Pessoa.class, 2); //procurando no BD os dados de id 2 e convertendo em obj pessoa e instanciando em p
		
		em.getTransaction().begin();
		em.remove(p); //removendo do BD (só funciona com objs monitorados)
		em.getTransaction().commit();
				
		System.out.println("Pronto!");
		em.close();
		emf.close();
	}

}
