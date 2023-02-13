package com.example.database.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.database.entity.Provincia;

public class ProvinceJpaDAO extends AbstractJpaDAO<Provincia, Integer> {
	private static Logger log = LogManager.getLogger();
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariadb");

	@Override
	public List<Provincia> findAll() {
		// creo l'equivalente della connessione
		EntityManager em = emf.createEntityManager();

		log.trace("Entity manager creato");

		// query jpql per elencare tutte le province
		String jpql = "select e from Provincia e";

		// equivalente del jdbc PreparedStatement per JPA
		TypedQuery<Provincia> tq = em.createQuery(jpql, Provincia.class);

		// ottengo il risultato equivalente al ResultSet
		List<Provincia> province = tq.getResultList();

		province.forEach(log::debug);

		em.close();
		//emf.close();
		return province;
	}

}
