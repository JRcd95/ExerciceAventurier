package fr.exerciceAventurier.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapUploader {

	public final static String MAP_PATH = "storage/carte.txt";
	
	public static ArrayList<String> getMap(){
		
		ArrayList<String> map = new ArrayList<String>();
		
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(MAP_PATH));){
			String line;

			while((line = bufferedReader.readLine()) != null) {
				map.add(line);
			}
			
		} catch (FileNotFoundException e) {
			System.err.printf("Impossible de trouver le fichier %s", MAP_PATH);
		} catch (IOException e) {
			System.err.printf("Impossible de lire le contenu du fichier %s", MAP_PATH);
		} 
 
		return map;
	}
}
