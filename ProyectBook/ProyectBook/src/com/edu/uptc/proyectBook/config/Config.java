package com.edu.uptc.proyectBook.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class Config {
	private static Config config;
	private String pathFile;
	private String nameFileCSV;
	private String nameFileJson;
	private String nameFileXML;
	private String nameFile;
	private String nameFileSer;
	private String nameFileUserSer;
	private Properties properties;
	
	
	private Config() {
		this.properties= new Properties();
		try (FileInputStream entrada = new FileInputStream("resources/config/appConfig.properties")) {
			properties.load(entrada);
            this.pathFile = properties.getProperty("app.config.path.files");
            this.nameFile =  properties.getProperty("app.config.path.file.name.txt");
            this.nameFileCSV = properties.getProperty("app.config.path.file.name.csv");
            this.nameFileJson = properties.getProperty("app.config.path.file.name.json");
            this.nameFileXML = properties.getProperty("app.config.path.file.name.xml");
            this.nameFileSer = properties.getProperty("app.config.path.file.name.ser");
            this.nameFileUserSer = properties.getProperty("app.config.path.file.name.user.ser");
        } catch (IOException ex) {
            System.err.println("Error al cargar el archivo properties de configuración: " + ex.getMessage());
        }
	}
	
	public static Config getInstance() {
		if(Objects.isNull(config)) {
			config = new Config();
		}
		return config;
	}
	
	
	
	public String getNameFileXML() {
		return nameFileXML;
	}

	public void setNameFileXML(String nameFileXML) {
		this.nameFileXML = nameFileXML;
	}

	public String getNameFileJson() {
		return nameFileJson;
	}

	public void setNameFileJson(String nameFileJson) {
		this.nameFileJson = nameFileJson;
	}

	public String getNameFileCSV() {
		return nameFileCSV;
	}

	public void setNameFileCSV(String nameFileCSV) {
		this.nameFileCSV = nameFileCSV;
	}

	public String getPathFile() {
		return pathFile;
	}
	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}
	public String getNameFile() {
		return nameFile;
	}
	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}

	public String getNameFileSer() {
		return nameFileSer;
	}

	public void setNameFileSer(String nameFileSer) {
		this.nameFileSer = nameFileSer;
	}

	public String getNameFileUserSer() {
		return nameFileUserSer;
	}

	public void setNameFileUserSer(String nameFileUserSer) {
		this.nameFileUserSer = nameFileUserSer;
	}
	
	
	
	
}
