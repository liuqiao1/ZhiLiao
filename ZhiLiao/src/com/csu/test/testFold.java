package com.csu.test;

import java.util.List;

import com.csu.bean.Save;
import com.csu.dao.SaveDao;
import com.csu.dao.impl.SaveDaoImpl;

public class testFold {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testFold tFold=new testFold();
		/*tFold.testInsert();*/
		//tFold.testFindFoldByuser();
		//tFold.testDelete();
		tFold.testUpdate();
	}
	
	public void testInsert() {
		SaveDao saveDao=new SaveDaoImpl();
		Save save=new Save();
		save.setFoldName("g");
		save.setFoldDes("in csu");
		save.setIsPublic(1);
		
		boolean result=saveDao.addFold(save);
		
		System.out.println(result);
		
	}
	public void testDelete() {
		SaveDao saveDao=new SaveDaoImpl();
		Save fold = new Save();
		fold.setFoldId(2);
		boolean result = saveDao.deleteFold(fold);
		System.out.println(result);
		
	}
	
	public void testUpdate() {
		SaveDao saveDao=new SaveDaoImpl();
		Save fold = new Save();
		fold.setFoldName("这是新的名字");
		fold.setFoldDes("xindemiaoshu");
		fold.setIsPublic(0);
		
		
		boolean result = saveDao.updateFold(fold);
		System.out.println(result);
		
		
	}
	
	 public static void testFindFoldByuser() {
		 SaveDao saveDao = new SaveDaoImpl();
		 List<Save> folds=saveDao.getSaveByuserId(1);
		 System.out.println(folds.size());
		
	}

}
