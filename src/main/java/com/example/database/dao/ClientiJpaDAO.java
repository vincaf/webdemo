package com.example.database.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.database.entity.Cliente;
import com.example.database.entity.Provincia;

public class ClientiJpaDAO extends AbstractJpaDAO<Cliente, Integer> {
	private static Logger log = LogManager.getLogger();
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariadb");

	@Override
	public List<Cliente> findAll() {
		// creo l'equivalente della connessione
		EntityManager em = emf.createEntityManager();

		log.trace("Entity manager creato");

		// query jpql per elencare tutte le province
		String jpql = "select c from Cliente c";

		// equivalente del jdbc PreparedStatement per JPA
		TypedQuery<Cliente> tq = em.createQuery(jpql, Cliente.class);

		// ottengo il risultato equivalente al ResultSet
		List<Cliente> clienti = tq.getResultList();

		clienti.forEach(log::debug);

		em.close();
		//emf.close();
		return clienti;
	}
	
	@Override
	public Cliente create(Cliente entity) {
		EntityManager em = emf.createEntityManager();
		log.trace("EntityManager creato");
		
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return entity;
	}

}
