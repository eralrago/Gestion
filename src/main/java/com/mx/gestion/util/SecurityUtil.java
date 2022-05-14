package com.mx.gestion.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

public class SecurityUtil {
	
	public String getRandomString() {
		String randomString = null;
		CharacterRule alphabets  = null;
		CharacterRule digits     = null;
		PasswordGenerator pwdGen = null;
		
		//Generar cadena de caracteres aleatoria en claro
		alphabets = new CharacterRule(EnglishCharacterData.Alphabetical);
		digits    = new CharacterRule(EnglishCharacterData.Digit);
		pwdGen    = new PasswordGenerator();
		
		randomString = pwdGen.generatePassword(20, alphabets, digits);
		
		return randomString;
	}
	
	public String getSHA512(String texto) {
		String hash = null;
		hash = DigestUtils.sha512Hex(texto);
		return hash;
	}
}
