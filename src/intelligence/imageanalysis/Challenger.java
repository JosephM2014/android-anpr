package intelligence.imageanalysis;

import intelligence.imageanalysis.Graph.Peak;

import java.util.LinkedList;

/**
 * ����������
 * @author azhdanov
 */
public class Challenger {
	
	/**
	 * ��� �������� �������� �����.
	 * �� ���� ��� ���� ����� ���� ���������� ����� � ��������� �������. 
	 * ��� ����� ��� ������ ������ �������� LinkedList
	 */
	public LinkedList<Integer> elems = new LinkedList<Integer>();
	public LinkedList<Integer> ids = new LinkedList<Integer>();
	
	public int minX;
	public int maxX;
	
	public int minY;
	public int maxY;
	
	//public int id;
	
	/**
	 * ��� ���������� �������� � ��������, � �������� �������� ���� ����� ����������� � ����������
	 */
	public final int COEF = 15;
	
	public Challenger(Peak p, int id, int startPosX, int endPosX) { 
		elems.add(p.getCenter());
		ids.add(id);
		minX = startPosX;
		maxX = endPosX;
		minY = p.left;
		maxY = p.right;		
	}
	
	
	public int getId() {
		return ids.getLast();
	}


	public boolean addPeak(Peak p, int id, int endPos) {
		int lastPoint = elems.getLast();
		if (Math.abs(lastPoint - p.center) <= COEF) {
			/**
			 * id �����������
			 */
			ids.add(id);
			elems.add(p.getCenter());
			maxX = Math.max(maxX, endPos);
			minY = Math.min(minY, p.left);
			maxY = Math.max(maxY, p.right);	
			return true;
		}
		return false;
	}
}
