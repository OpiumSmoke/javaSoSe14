package model;

import java.util.List;

import quiz.*;

public class Game {
	public static int maxrounds;
	public static int round = 1;
	public static String name;
	public static List<Question> qlist;
	public static SimpleController controller = new SimpleController();
	public static Question question;
}
