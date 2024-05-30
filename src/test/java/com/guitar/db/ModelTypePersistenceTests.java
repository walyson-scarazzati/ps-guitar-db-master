package com.guitar.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.guitar.db.model.ModelType;
import com.guitar.db.repository.ModelTypeJpaRepository;
import com.guitar.db.repository.ModelTypeRepository;

@ContextConfiguration(locations={"classpath:com/guitar/db/applicationTests-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ModelTypePersistenceTests {
	@Autowired
	private ModelTypeRepository modelTypeRepository;

	@Autowired
	private ModelTypeJpaRepository modelTypeJpaRepository;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Test
	@Transactional
	public void testSaveAndGetAndDelete() throws Exception {
		ModelType mt = new ModelType();
		mt.setName("Test Model Type");
		//mt = modelTypeRepository.create(mt); era antes de implementar o Spring data JPA
		mt = modelTypeJpaRepository.save(mt);
		
		// clear the persistence context so we don't return the previously cached location object
		// this is a test only thing and normally doesn't need to be done in prod code
		entityManager.clear();

		//ModelType otherModelType = modelTypeRepository.find(mt.getId()); era antes de implementar o Spring data JPA
		ModelType otherModelType = modelTypeJpaRepository.findOne(mt.getId());
		assertEquals("Test Model Type", otherModelType.getName());
		
		//modelTypeRepository.delete(otherModelType); era antes de implementar o Spring data JPA
		modelTypeJpaRepository.delete(otherModelType); 
	}

	@Test
	public void testFind() throws Exception {
	//	ModelType mt = modelTypeRepository.find(1L); era antes de implementar o Spring data JPA
		ModelType mt = modelTypeJpaRepository.findOne(1L);
		assertEquals("Dreadnought Acoustic", mt.getName());
	}
	@Test
	public void testForNull() throws Exception {
		List<ModelType> mt = modelTypeJpaRepository.findByNameIsNull();
		assertNull(mt.get(0).getName());
	}
}
