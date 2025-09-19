package com.edu.uptc.proyectBook.interfaces;

import com.edu.uptc.proyectBook.enums.ETypeFileEnum;

public interface IActionsFile {
	public void loadFile(ETypeFileEnum eTypeFileEnum);
	public void dumpFile(ETypeFileEnum eTypeFileEnum);
}
