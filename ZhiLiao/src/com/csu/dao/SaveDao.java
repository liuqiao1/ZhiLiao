package com.csu.dao;




import java.util.List;

import com.csu.bean.Save;

/**
 * 收藏 接口
 * @author KING
 * 对应数据库回答表：fold
 * @use 对表fold 进行增删改查操作，并对相关表进行级联操作
 * @time 创建时间：2016-12-8 修改时间：2016-12-8
 */

public interface SaveDao {
	
	/**
	 * 新建一个收藏夹
	 * @author KING
	 * @param fold 添加的收藏夹
	 * @return 是否添加成功：true代表成功，false代表失败
	 * @time 创建时间：2016-12-8 修改时间：2016-12-8
	 */
	public boolean addFold(Save fold);
	
	/**
	 * 删除一个收藏夹
	 * @author KING
	 * @param fold 待删除的收藏夹
	 * @return 是否删除成功：true代表成功，false代表失败
	 * @time 创建时间：2016-12-11 修改时间：2016-12-11
	 */
	public boolean deleteFold(Save fold);
	
	/**
	 * 修改一个收藏夹
	 * @author KING
	 * @param foldId 原收藏夹编号
	 * @param fold 新收藏夹
	 * @return 是否修改成功：true代表成功，false代表失败
	 * @time 创建时间：2016-12-11 修改时间：2016-12-11
	 */
	public boolean updateFold(Save fold);
	
	/**
	 * 根据用户编号查找该用户的所有收藏夹
	 * @author KING
	 * @param userId 用户的编号
	 * @return List<Save> 查找到的收藏夹列表：如果为null说明无法查找
	 * @time 创建时间：2016-12-12修改时间：2016-12-15
	 */	
	public List<Save> getSaveByuserId(int userId);
	
	/**收藏一个回答
	 * @author KING
	 * @param answerId 回答的编号
	 * @return 
	 * @time 创建时间：2016-12-12修改时间：2016-12-16
	 */	
	public boolean insertSave(int answerId);

}
