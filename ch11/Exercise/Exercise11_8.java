package 연습문제11_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


class Student implements Comparable{
	String name;
	int ban;
	int no;
	int kor, eng, math;
	
	int total;
	int schoolRank;
	
	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		total = kor+eng+math;
		
	}
	
	int getTotal() {
		return total;
	}
	
	float getAverage() {
		return (int)((getTotal()/3f) * 10 + 0.5) / 10f;
	}
	
	public int compareTo(Object o) {
		if(o instanceof Student) {
			Student tmp = (Student)o;
			return tmp.total - this.total;
		} else {
			return -1;
		}
	}
	
	public String toString() {
		return name + "," + 
				ban + "," +
				no + "," + 
				kor + "," + 
				eng + "," + 
				math + "," + 
				getTotal() + "," + 
				getAverage() + "," +
				schoolRank;
	}
}	// class Student

public class Exercise11_8 {
	public static void calculateSchoolRank(List list) {
		Collections.sort(list);
		
		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();
		
		for(int i=0;i<length;i++) {
			Student s = (Student)list.get(i);
			if(s.total == prevTotal) {
				s.schoolRank = prevRank;
			} else {
				s.schoolRank = i + 1;
			}
			prevRank = s.schoolRank;
			prevTotal = s.total;
		}
	}

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student("이자바",2,1,70,90,70));
		list.add(new Student("안자바",2,2,60,100,80));
		list.add(new Student("홍길동",1,3,100,100,100));
		list.add(new Student("남궁성",1,1,90,70,80));
		list.add(new Student("김자바",1,2,80,80,90));
		
		calculateSchoolRank(list);
		
		Iterator it = list.iterator();
		
		while(it.hasNext())
			System.out.println(it.next());
	}

}