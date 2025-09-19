package com.edu.upc.proyectBook.view;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import com.edu.uptc.proyectBook.enums.ETypeFileEnum;
import com.edu.uptc.proyectBook.persistence.PersistenceUsuario;

public class EventsLoginWindow implements ActionListener{

	static final String VALIDATE_LOGIN = "VALIDATE_LOGIN";
	private PanelRightLoginWindow panelRightLoginWindow;
	private PersistenceUsuario persistenceUsuario;

	public EventsLoginWindow(PanelRightLoginWindow panelRightLoginWindow) {
		this.panelRightLoginWindow = panelRightLoginWindow;
		this.persistenceUsuario = persistenceUsuario;
		this.persistenceUsuario.loadFile(ETypeFileEnum.SER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case VALIDATE_LOGIN: {
			String nameUser = this.panelRightLoginWindow.getInputUserName().getText();
			String password = this.panelRightLoginWindow.getInputPassword().getText();
			
			if (Boolean.TRUE.equals(this.persistenceUsuario.findUserByUserNamePassword(nameUser, password))) {
				Window ventana = SwingUtilities.getWindowAncestor(this.panelRightLoginWindow);
				if (ventana != null) {
					ventana.setVisible(false);
					
					this.panelRightLoginWindow.getMainWindow().setVisible(true); 
					this.panelRightLoginWindow.getLblMessageError().setVisible(false);
					
			}
			}else {
				this.panelRightLoginWindow.getLblMessageError().setVisible(true);
			}
			break;
			
		}
		default:
		
		}
		
	}
	
}
