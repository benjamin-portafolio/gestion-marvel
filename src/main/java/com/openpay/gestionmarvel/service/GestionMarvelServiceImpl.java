package com.openpay.gestionmarvel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.openpay.libreriamarvel.app.LibreriaMarvelAppImpl;
import com.openpay.gestionmarvel.model.Usuario;
import com.openpay.gestionmarvel.repository.UsuarioRepository;
//import com.openpay.gestionmarvel.repositry.UsuarioRepository;
import com.openpay.libreriamarvel.VO.CharactersByIdInVO;

@SpringBootApplication
@EnableJpaRepositories
@Configuration
@ComponentScan(basePackages = "com.openpay.gestionmarvel")
@Component
@Service

public class GestionMarvelServiceImpl implements GestionMarvelService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Value("${marvel.public.key}")
	String publicKey;
	
	@Value("${marvel.private.key}")
	String privateKey;
	
	@Override
	public String Test() {
		LibreriaMarvelAppImpl libreria = new LibreriaMarvelAppImpl();
		return libreria.getCharacters(publicKey, privateKey);
	}
	
	@Override
	public String pruebaCharacters() {
		LibreriaMarvelAppImpl libreria = new LibreriaMarvelAppImpl();
		CharactersByIdInVO charactersByIdInVO = new CharactersByIdInVO();
		charactersByIdInVO.setId(323);
		charactersByIdInVO.setPublicKey(publicKey);
		charactersByIdInVO.setPrivateKey(privateKey);
		return libreria.getCharactersById(charactersByIdInVO);
	}
	@Override
	public Usuario createUsuario(Usuario usuario) {
	//	return usuarioRepository.save(usuario);
		return usuario;
	}

}
