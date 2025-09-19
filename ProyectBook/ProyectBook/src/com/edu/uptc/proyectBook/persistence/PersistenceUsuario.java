package com.edu.uptc.proyectBook.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import com.edu.uptc.proyectBook.enums.ETypeFileEnum;
import com.edu.uptc.proyectBook.interfaces.IActionsFile;
import com.edu.uptc.proyectBook.model.User;

public class PersistenceUsuario extends FilePlain implements IActionsFile{
	private List<User> listUsers;
	
	public PersistenceUsuario() {
		this.listUsers = new ArrayList<User>();
	}
	
	public Boolean findUserByUserNamePassword(String nameUser, String password) {
		return listUsers.stream().anyMatch(u -> u.getUsername().equals(nameUser) && u.getPassword().equals(password));
	}

	@Override
	public void loadFile(ETypeFileEnum eTypeFileEnum) {
		if (ETypeFileEnum.SER.equals(eTypeFileEnum)) {
			this.loadFileSerializate();
		}
		
	}

	@Override
	public void dumpFile(ETypeFileEnum eTypeFileEnum) {
		if (ETypeFileEnum.SER.equals(eTypeFileEnum)) {
			this.dumpFileSerializate();
		}
		
	}
	
	private void dumpFileSerializate() {
		try (FileOutputStream fileOut = new FileOutputStream(this.config.getPathFile().concat(this.config.getNameFileUserSer()));
			ObjectOutputStream out = new ObjectOutputStream(fileOut)){
			out.writeObject(this.listUsers);
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	private void loadFileSerializate() {
		try (FileInputStream fileIn = new FileInputStream(this.config.getPathFile().concat(this.config.getNameFileUserSer()));
				ObjectInputStream in = new ObjectInputStream(fileIn)){
			this.listUsers = (List<User>) in.readObject();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<User> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}

	
}
