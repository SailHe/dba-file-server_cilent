package com.nit.demo.file;

import java.io.File;

public class FileList {

	public static void main(String args[]) {
		File dir = new File("./");
		File file[] = dir.listFiles();
		for (int i = 0; i < file.length; i++) {
			System.out.println(file[i].getName());
		}
	}
}
