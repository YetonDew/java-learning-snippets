package Task_07;
public class TaskSeven {
	public static String norm(String name) {
		char[] chars = name.toCharArray();
		int i = 0;
		while(i < name.length())
		{
			if(i == 0)
				chars[i] = Character.toUpperCase(chars[i]);
			else
				chars[i] = Character.toLowerCase(chars[i]);
			i++;
		}
		return new String(chars);
	}

	public static String init(String name) {
		String[] nameSplited = name.split(" ");
		StringBuilder newName = new StringBuilder();
		int i = 0;

		while(i < nameSplited.length - 1)
		{
			char[] chars = nameSplited[i].toCharArray();
			newName.append(Character.toUpperCase(chars[0]));
			newName.append(". ");
			i++;
		}
		newName.append(norm(nameSplited[nameSplited.length - 1]));
		return newName.toString();
	}

	public static String tr(String s, String from, String to) {
		int i = 0;
		while(i < from.length())
		{
			s = s.replaceAll(String.valueOf(from.charAt(i)), String.valueOf(to.charAt(i)));
			i++;
		}
		return s;
	}

	public static void main(String[] args) {
		System.out.println(norm("caravaggio"));
		System.out.println(norm("VERMEER"));
		System.out.println(init("johann sebastian bach"));
		System.out.println(init("i. babeL"));
		System.out.println(init("jorge LUIS BORGES"));
		System.out.println(init("WOLFGANG a. mozart"));
		System.out.println(tr("Mississippi",
		 		"abcdefghijklmnopqrstuvwyz",
		 		"BCDEFGHIJKLMNOPQRSTUVWYZA"));
		 System.out.println(tr("abcXYZ", "aZcX", "||Cx"));
	}
}
