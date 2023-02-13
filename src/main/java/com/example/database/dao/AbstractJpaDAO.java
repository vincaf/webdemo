package com.example.database.dao;

import java.util.Collection;
import java.util.List;

public abstract class AbstractJpaDAO<ENTITY, KEY> implements DAO<ENTITY, KEY> {

	@Override
	public Long count() {
		throw new DAOMethodNotYetImplementedException("count() not yet implemented ...");
	}

	@Override
	public List<ENTITY> findAll() {
		throw new DAOMethodNotYetImplementedException("findAll() not yet implemented ...");
	}

	@Override
	public ENTITY findById(KEY id) {
		throw new DAOMethodNotYetImplementedException("findById(KEY id) not yet implemented ...");
	}

	@Override
	public ENTITY create(ENTITY entity) {
		throw new DAOMethodNotYetImplementedException("create(ENTITY entity) not yet implemented ...");
	}

	@Override
	public Collection<ENTITY> create(Collection<ENTITY> entities) {
		throw new DAOMethodNotYetImplementedException("create(Collection<ENTITY> entities) not yet implemented ...");
	}

	@Override
	public Boolean merge(ENTITY entity) {
		throw new DAOMethodNotYetImplementedException("merge(ENTITY entity) not yet implemented ...");
	}

	@Override
	public Boolean merge(Collection<ENTITY> entities) {
		throw new DAOMethodNotYetImplementedException("merge(Collection<ENTITY> entities) not yet implemented ...");
	}

	@Override
	public Boolean removeById(KEY id) {
		throw new DAOMethodNotYetImplementedException("removeById(KEY id) not yet implemented ...");
	}

	@Override
	public Boolean remove(ENTITY entity) {
		throw new DAOMethodNotYetImplementedException("remove(ENTITY entity) not yet implemented ...");
	}

	@Override
	public Boolean remove(Collection<ENTITY> entities) {
		throw new DAOMethodNotYetImplementedException("remove(Collection<ENTITY> entities) not yet implemented ...");
	}

}
