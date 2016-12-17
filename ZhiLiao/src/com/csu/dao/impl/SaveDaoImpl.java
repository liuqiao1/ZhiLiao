package com.csu.dao.impl;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csu.bean.Save;
import com.csu.dao.SaveDao;
import com.csu.util.DBUtil;
import com.mysql.jdbc.PreparedStatement;

/**
 * 收藏接口实现类
 * @author KING
 * @time 创建时间：2016年12月8日 最后修改时间：2016年12月8日
 */

public class SaveDaoImpl implements SaveDao {
	
	PreparedStatement ps;
	ResultSet rs;
	Connection connection;
	int result;
	
	/**
	 * 添加一个新的收藏夹进入fold表
	 * @param fold 要插入的新的收藏夹
	 * @return 新建结果 
	 */

	@Override
	public boolean addFold(Save fold) {
		// TODO Auto-generated method stub
		System.out.println("fold in dao:"+fold);
		String sql = "insert into "
				+"fold(foldName,foldDes,isPublic,userId) "
				+ "values(?,?,?,?)";
		connection = DBUtil.getConnection();
		try {
			ps=(PreparedStatement) connection.prepareStatement(sql);
			ps.setString(1, fold.getFoldName());
			ps.setString(2, fold.getFoldDes());
			ps.setInt(3, fold.getIsPublic());
			ps.setInt(4, fold.getUser().getUserId());//用户编号
			
			result=ps.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result==0) {
			return false;
		}
		else return true;
	}

	
	/**
	 * 删除一个收藏夹从fold表
	 * @param fold 待删除收藏夹
	 * @return 删除结果 
	 * delete from fold WHERE fold。foldId=1
	 */
	@Override
	public boolean deleteFold(Save fold) {
		// TODO Auto-generated method stub
		String sql="delete from fold WHERE fold.foldId=?";
		connection = DBUtil.getConnection();
		try {
			ps=(PreparedStatement) connection.prepareStatement(sql);
			ps.setInt(1, fold.getFoldId());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result==0) {
			return false;
		}
		else return true;
	}
	
	
	/**
	 * 修改一个收藏夹
	 * @param fold 更新后的收藏夹
	 * @param foldId 待更新收藏夹的编号
	 * @return 更新结果 
	 * update fold SET foldName='this is new' WHERE foldId=3
	 */
	@Override
	public boolean updateFold(Save fold) {
		// TODO Auto-generated method stub
		
		System.out.println("new fold:"+fold);
		String sql = "update fold SET foldName=?,foldDes=?,isPublic=? WHERE foldId=?";
		connection = DBUtil.getConnection();
		try {
			ps=(PreparedStatement) connection.prepareStatement(sql);
			ps.setString(1, fold.getFoldName());
			ps.setString(2, fold.getFoldDes());
			ps.setInt(3,fold.getIsPublic());
			ps.setInt(4,fold.getFoldId());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result==0) {
			return false;
		}
		else return true;
		
	}
	
	
	
	/**
	 * 根据用户编号查找该用户所有的收藏夹
	 * @param userId 问题编号
	 * @return 找到的收藏夹
	 * SELECT fold.*
		FROM fold,users
		WHERE users.userId=1
		  
	 */
	@Override
	public List<Save> getSaveByuserId(int userId) {
		// TODO Auto-generated method stub
		/*String sql="SELECT fold.* "
				+"FROM fold,users "
				+"WHERE fold.userId=?";*/
		String sql="select distinct fold.* from fold,user where fold.userId=?";
		List<Save> folds = new ArrayList<>();
		Save fold = null;
		connection = DBUtil.getConnection();
		try {
			ps=(PreparedStatement) connection.prepareStatement(sql);
			ps.setInt(1, userId);
			rs=ps.executeQuery();
			while(rs.next())
			{
				fold = new Save();
				fold.setFoldId(rs.getInt("foldId"));
				fold.setFoldName(rs.getString("foldName"));
				fold.setFoldDes(rs.getString("foldDes"));
				fold.setIsPublic(rs.getInt("isPublic"));
				
				folds.add(fold);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return folds;
	}

	/**收藏一个回答
	 * @author KING
	 * @param answerId 回答的编号
	 * @return 
	 * @time 创建时间：2016-12-12修改时间：2016-12-16
	 */	
	@Override
	public boolean insertSave(int answerId) {
		// TODO Auto-generated method stub
		
		
		return false;
	}

	

	
	
	

	
	
	
}
