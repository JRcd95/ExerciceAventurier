package fr.exerciceAventurier.app;

import java.util.ArrayList;

import fr.exerciceAventurier.entities.Position;
import fr.exerciceAventurier.entities.Way;
import fr.exerciceAventurier.utils.MapUploader;

public class Movement {

	public static Position wayTranslation(char direction, Position position, ArrayList<String> map ) {
		
		final char WOOD = '#';
		final int NORTH = position.getY() - 1;
		final int SOUTH = position.getY() + 1;
		final int EAST = position.getX() + 1;
		final int WEST = position.getX() - 1;
		final int X_MIN = 0;
		final int X_MAX = map.get(position.getY()).length();
		final int Y_MIN = 0;
		final int Y_MAX = map.size();
		final int X_POSITION = position.getX();
		final int Y_POSITION = position.getY();
		
		/*Pour chaque déplacement, on vérifie que :
		  		- Le personnage ne peut pas aller sur les cases occupées par les bois impénétrables.
				- Le personnage ne peut pas aller au-delà des bords de la carte.
		 */
		switch(direction) {
			case 'N':
				if(WOOD != map.get(NORTH).charAt(X_POSITION) && Y_POSITION > X_MIN) {
					position.setY(NORTH);
				}
				break;
			case 'S':
				if(WOOD != map.get(SOUTH).charAt(X_POSITION) && Y_POSITION < Y_MAX) {
					position.setY(SOUTH);
				}
				break;
				
			case 'E':
				if(WOOD != map.get(Y_POSITION).charAt(EAST) && X_POSITION < X_MAX) {
					position.setX(EAST);
				}
				break;
				
			case 'O':
				if(WOOD != map.get(Y_POSITION).charAt(WEST) && X_POSITION > Y_MIN) {
					position.setX(WEST);
				}
				break;
		}
		return position;
	}
	
	public static Position travelMap(int x, int y, String route) {
		
		Position position =  new Position(x,y);
		ArrayList<String> map = MapUploader.getMap();
		Way way =  new Way(route);
		
		for (char direction: way.getWay().toCharArray()) {
			Movement.wayTranslation(direction, position, map);
		}
		return position;
	}
}
