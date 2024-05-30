package com.guitar.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guitar.db.model.Location;

@Repository
public interface LocationJpaRepository extends JpaRepository<Location, Long>{
	
	//keyword veja o método findByStateLike(String stateName)  que foi colocado no LocationJpaRepository  autor explica que nome serve para sintaxe exemplo a palavra state 
	//se refere ao campo da tabela Location mas da onde surgiu o Location? Do extends JpaRepository<Location, Long> o like para comparar o texto, no parâmetro colocou stateName 
	//vira o :state na query confira
	List<Location> findByStateLike (String stateName);
	
	//Serio o substituto do metodo acima
	List<Location> findByStateStartingWith(String stateName);
	
	//keyword veja o método findByStateNotLike(String stateName)  que foi colocado no LocationJpaRepository  autor explica que nome serve para sintaxe exemplo a palavra state 
	//se refere ao campo da tabela Location mas da onde surgiu o Location? Do extends JpaRepository<Location, Long> o like para comparar o texto, no parâmetro colocou stateName 
	//Not para negar
	//vira o :state na query confira
	List<Location> findByStateNotLike (String stateName);
	
	//keyword veja o método findByStateOrCountry(string value, String value2)  que foi colocado no LocationJpaRepository  autor explica que nome serve para sintaxe exemplo a palavra state e
	// country entre essas palavras tem o OR que serve para condicional quando ele for fazer para query ele pode buscar por state ou country 
	//state e country se refere ao campo da tabela Location mas da onde surgiu o Location? Do extends JpaRepository<Location, Long> o like para comparar o texto, no parâmetro colocou value e value2 
	//vira o :value e :value2 na query confira
	List<Location> findByStateOrCountry(String value, String value2);
	
	//keyword veja o método findByStateAndCountry(string value, String value2)  que foi colocado no LocationJpaRepository  autor explica que nome serve para sintaxe exemplo a palavra state e
	// country entre essas palavras tem o AND que serve para condicional quando ele for fazer para query ele faz busca por state e country tem que possuir ambos valores
	//state e country se refere ao campo da tabela Location mas da onde surgiu o Location? Do extends JpaRepository<Location, Long> o like para comparar o texto, no parâmetro colocou value e value2 
	//vira o :value e :value2 na query confira
	List<Location> findByStateAndCountry(String value, String value2);
	
	//keyword veja o método findByStateIsOrCountryEquals(string value, String value2)  que foi colocado no LocationJpaRepository  autor explica que nome serve para sintaxe exemplo a palavra state e
	// country entre essas palavras tem o OR que serve para condicional quando ele for fazer para query ele pode buscar por state ou country 
	//state e country se refere ao campo da tabela Location mas da onde surgiu o Location? Do extends JpaRepository<Location, Long> o like para comparar o texto, no parâmetro colocou value e value2 
	//vira o :value e :value2 na query confira
	List<Location> findByStateIsOrCountryEquals(String value, String value2);
	
	//keyword veja o método findByStateNot(string state)  que foi colocado no LocationJpaRepository  autor explica que nome serve para sintaxe exemplo a palavra state e
	// country entre essas palavras tem o AND que serve para condicional quando ele for fazer para query ele faz busca por state e country tem que possuir ambos valores
	//state e country se refere ao campo da tabela Location mas da onde surgiu o Location? Do extends JpaRepository<Location, Long> o like para comparar o texto, no parâmetro colocou value e value2 
	//Not para negar
	//vira o :state na query confira
	List<Location> findByStateNot(String state);
	
	List<Location> findByStateIgnoreCaseStartingWith(String stateName);
	
	List<Location> findByStateNotLikeOrderByStateAsc(String stateName);
	
	Location findFirstByStateIgnoreCaseStartingWith(String stateName);
}
