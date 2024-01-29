package 연습문제11_9;

import java.util.*;

class Student implements Comparable{
	String name;
	int ban;
	int no;
	int kor, eng, math;
	
	int total;
	int schoolRank;
	int classRank;
	
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
				schoolRank + "," +
				classRank;
	}
}	// class Student

class ClassTotalComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		Student s1 = (Student)o1;
		Student s2 = (Student)o2;
		int result = s1.ban - s2.ban;
		if(result == 0)
			result = s2.total - s1.total;
		return result;
	}
}

public class Exercise11_9 {
	public static void calculateClassRank(List list) {
		// 먼저 반별 총점 기준 내림차순으로 정렬한다.
		Collections.sort(list, new ClassTotalComparator());
		
		int prevBan = -1;
		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();
		
		for(int i=0, n=0;i<length;i++,n++) {
			Student s = (Student)list.get(i);
			if(s.ban != prevBan) {
				prevRank = -1;
				prevTotal = -1;
				n=0;
			}
			if(s.total == prevTotal) {
				prevRank = s.classRank;
			} else {
				s.classRank = n+1;
			}
			prevBan = s.ban;
			prevTotal = s.total;
			prevRank = s.classRank;
		}
	} // calculateClassRank
	
	public static void calculateSchoolRank(List list) {
		Collections.sort(list);	// 먼저 list를 총점 기준 내림차순으로 정렬
		
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
		calculateClassRank(list);
		
		Iterator it = list.iterator();
		
		while(it.hasNext())
			System.out.println(it.next());
	}
	
}
