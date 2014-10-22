package com.ntu.auto.magazine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ntu.auto.magazine.filter.SearchFilter;
import com.ntu.auto.magazine.model.Advertisement;
import com.ntu.auto.magazine.util.DataSourceUtil;

public class AutomobileDaoImpl implements AutomobileDao {

	private Connection con;
	private PreparedStatement pst;
	private ResultSet rst;
	
	public Connection getCon() {
		if(con == null){
			con = DataSourceUtil.getConnection();
		}
		return con;
	}

	@Override
	public List<Advertisement> getAllAdvertisements() {
		List<Advertisement> advList = new ArrayList<Advertisement>();
		con = DataSourceUtil.getConnection();
		if(con != null){
			try{
				pst = con.prepareStatement("SELECT adv_id,name,email,contact,address,location,title,make,model,model_no,make_year,reg_year,price,photo1,photo2,photo3,photo4,additional_info,approved,post_dt,publish_dt,category,engine_capacity,gear,mileage FROM advertisement");
				rst = pst.executeQuery();
				while(rst.next()){
					Advertisement adv = new Advertisement();
					adv.setAdvId(rst.getLong("adv_id"));
					adv.setName(rst.getString("name"));
					adv.setEmail(rst.getString("email"));
					adv.setContact(rst.getString("contact"));
					adv.setAddress(rst.getString("address"));
					adv.setLocation(rst.getString("location"));
					adv.setTitle(rst.getString("title"));
					adv.setMake(rst.getString("make"));
					adv.setModel(rst.getString("model"));
					adv.setModelNumber(rst.getString("model_no"));
					adv.setMakeYear(rst.getString("make_year"));
					adv.setRegisteredYear(rst.getString("reg_year"));
					adv.setPrice(rst.getDouble("price"));
					adv.setPhoto1(rst.getBinaryStream("photo1"));
					adv.setPhoto2(rst.getBinaryStream("photo2"));
					adv.setPhoto3(rst.getBinaryStream("photo3"));
					adv.setPhoto4(rst.getBinaryStream("photo4"));
					adv.setAdditionalInfo(rst.getString("additional_info"));
					adv.setApproved(rst.getInt("approved"));
					adv.setPostedDate(rst.getDate("post_dt"));
					adv.setPublishDate(rst.getDate("publish_dt"));
					adv.setCategory(rst.getString("category"));
					adv.setGear(rst.getString("gear"));
					adv.setEngineCapacity(rst.getInt("engine_capacity"));
					adv.setMileage(rst.getInt("mileage"));
					advList.add(adv);
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					con.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return advList;
	}

	@Override
	public List<Advertisement> getLatestAdvertisements() {
		List<Advertisement> advList = new ArrayList<Advertisement>();
		con = DataSourceUtil.getConnection();
		if(con != null){
			try{
				pst = con.prepareStatement("SELECT adv_id,name,email,contact,address,location,title,make,model,model_no,make_year,reg_year,price,photo1,photo2,photo3,photo4,additional_info,approved,post_dt,publish_dt,category,engine_capacity,gear,mileage FROM advertisement  WHERE publish_dt is not null order by publish_dt limit 0,4");
				rst = pst.executeQuery();
				while(rst.next()){
					Advertisement adv = new Advertisement();
					adv.setAdvId(rst.getLong("adv_id"));
					adv.setName(rst.getString("name"));
					adv.setEmail(rst.getString("email"));
					adv.setContact(rst.getString("contact"));
					adv.setAddress(rst.getString("address"));
					adv.setLocation(rst.getString("location"));
					adv.setTitle(rst.getString("title"));
					adv.setMake(rst.getString("make"));
					adv.setModel(rst.getString("model"));
					adv.setModelNumber(rst.getString("model_no"));
					adv.setMakeYear(rst.getString("make_year"));
					adv.setRegisteredYear(rst.getString("reg_year"));
					adv.setPrice(rst.getDouble("price"));
					adv.setPhoto1(rst.getBinaryStream("photo1"));
					adv.setPhoto2(rst.getBinaryStream("photo2"));
					adv.setPhoto3(rst.getBinaryStream("photo3"));
					adv.setPhoto4(rst.getBinaryStream("photo4"));
					adv.setAdditionalInfo(rst.getString("additional_info"));
					adv.setApproved(rst.getInt("approved"));
					adv.setPostedDate(rst.getDate("post_dt"));
					adv.setPublishDate(rst.getDate("publish_dt"));
					adv.setCategory(rst.getString("category"));
					adv.setGear(rst.getString("gear"));
					adv.setEngineCapacity(rst.getInt("engine_capacity"));
					adv.setMileage(rst.getInt("mileage"));
					advList.add(adv);
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					con.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return advList;
	}

	@Override
	public Advertisement getAdvertisementById(long advId) {
		con = DataSourceUtil.getConnection();
		Advertisement adv = new Advertisement();
		if(con != null){
			try{
				pst = con.prepareStatement("SELECT adv_id,name,email,contact,address,location,title,make,model,model_no,make_year,reg_year,price,photo1,photo2,photo3,photo4,additional_info,approved,post_dt,publish_dt,category,engine_capacity,gear,mileage FROM advertisement WHERE adv_id=?");
				pst.setLong(1, advId);
				rst = pst.executeQuery();
				while(rst.next()){
					adv.setAdvId(rst.getLong("adv_id"));
					adv.setName(rst.getString("name"));
					adv.setEmail(rst.getString("email"));
					adv.setContact(rst.getString("contact"));
					adv.setAddress(rst.getString("address"));
					adv.setLocation(rst.getString("location"));
					adv.setTitle(rst.getString("title"));
					adv.setMake(rst.getString("make"));
					adv.setModel(rst.getString("model"));
					adv.setModelNumber(rst.getString("model_no"));
					adv.setMakeYear(rst.getString("make_year"));
					adv.setRegisteredYear(rst.getString("reg_year"));
					adv.setPrice(rst.getDouble("price"));
					adv.setPhoto1(rst.getBinaryStream("photo1"));
					adv.setPhoto2(rst.getBinaryStream("photo2"));
					adv.setPhoto3(rst.getBinaryStream("photo3"));
					adv.setPhoto4(rst.getBinaryStream("photo4"));
					adv.setAdditionalInfo(rst.getString("additional_info"));
					adv.setApproved(rst.getInt("approved"));
					adv.setPostedDate(rst.getDate("post_dt"));
					adv.setPublishDate(rst.getDate("publish_dt"));
					adv.setCategory(rst.getString("category"));
					adv.setGear(rst.getString("gear"));
					adv.setEngineCapacity(rst.getInt("engine_capacity"));
					adv.setMileage(rst.getInt("mileage"));
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					con.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		
		}
		return adv;
	}

	@Override
	public void addAdvertisement(Advertisement adv) {
		con = DataSourceUtil.getConnection();
		//long advId = getNextAdvId();
		String sql ="INSERT INTO advertisement(adv_id,name,email,contact,address,location,title,make,model,model_no,make_year,reg_year,price,photo1,photo2,photo3,photo4,additional_info,approved,post_dt,category,engine_capacity,gear,mileage)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NOW(),?,?,?,?)";
		if(con != null){
			try{
				pst = con.prepareStatement(sql);
				pst.setLong(1, adv.getAdvId());
				pst.setString(2, adv.getName());
				pst.setString(3, adv.getEmail());
				pst.setString(4, adv.getContact());
				pst.setString(5, adv.getAddress());
				pst.setString(6, adv.getLocation());
				pst.setString(7, adv.getTitle());
				pst.setString(8, adv.getMake());
				pst.setString(9, adv.getModel());
				pst.setString(10, adv.getModelNumber());
				pst.setString(11, adv.getMakeYear());
				pst.setString(12, adv.getRegisteredYear());
				pst.setDouble(13, adv.getPrice());
				pst.setBinaryStream(14, adv.getPhoto1());
				pst.setBinaryStream(15, adv.getPhoto2());
				pst.setBinaryStream(16, adv.getPhoto3());
				pst.setBinaryStream(17, adv.getPhoto4());
				pst.setString(18, adv.getAdditionalInfo());
				pst.setInt(19, 0);
				pst.setString(20, adv.getCategory());
				pst.setInt(21, adv.getEngineCapacity());
				pst.setString(22, adv.getGear());
				pst.setInt(23, adv.getMileage());
				pst.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					con.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void updateAdvertisement(Advertisement adv) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAdvertisement(long advId) {
		// TODO Auto-generated method stub

	}
	
	public long getNextAdvId(Connection con){
		long advId = 0;
		if(con != null){
			try {
				pst = con.prepareStatement("SELECT max(adv_id) + 1 as advid from advertisement");
				rst = pst.executeQuery();
				while(rst.next()){
					advId = rst.getLong("advid");
				}
				pst.close();
				rst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return advId;
	}
	
	public long getNextAdvId(){
		long advId = 0;
		con = DataSourceUtil.getConnection();
		if(con != null){
			try {
				pst = con.prepareStatement("SELECT max(adv_id) + 1 as advid from advertisement");
				rst = pst.executeQuery();
				while(rst.next()){
					advId = rst.getLong("advid");
				}
				pst.close();
				rst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try{
					con.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return advId;
	}

	@Override
	public List<Advertisement> searchAdvertisements(SearchFilter filter) {
		List<Advertisement> advList = new ArrayList<Advertisement>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT adv_id,name,email,contact,address,location,title,make,model,model_no,make_year,reg_year,price,photo1,photo2,photo3,photo4,additional_info,approved,post_dt,publish_dt,category,engine_capacity,gear,mileage FROM advertisement WHERE publish_dt is not null ");
		if(filter!=null){
			//sql.append(" WHERE publish_dt is not null ");
			if(!"".equals(filter.getCategory())){
				sql.append(" AND category="+"'"+filter.getCategory()+"'");
			}
			if(!"".equals(filter.getMake())){
				sql.append(" AND make="+"'"+filter.getMake()+"'");
			}
			if(!"".equals(filter.getModel())){
				sql.append(" AND model="+"'"+filter.getModel()+"'");
			}
			if(!"".equals(filter.getMakeYear())){
				sql.append(" AND make_year="+"'"+filter.getMakeYear()+"'");
			}
			if(!"".equals(filter.getRegisteredYear())){
				sql.append(" AND reg_year="+"'"+filter.getRegisteredYear()+"'");
			}
			if(!"".equals(filter.getEngineCapacity())){
				sql.append(" AND engine_capacity <="+"'"+filter.getEngineCapacity()+"'");
			}
			if(!"".equals(filter.getPrice())){
				sql.append(" AND price <="+"'"+filter.getPrice()+"'");
			}
			if(!"".equals(filter.getMileage())){
				sql.append(" AND mileage <="+"'"+filter.getMileage()+"'");
			}
			if(!"".equals(filter.getGear())){
				sql.append(" AND gear ="+"'"+filter.getGear()+"'");
			}
		}
		System.out.println(sql.toString());
		con = DataSourceUtil.getConnection();
		if(con != null){
			try{
				pst = con.prepareStatement(sql.toString());
				rst = pst.executeQuery();
				while(rst.next()){
					Advertisement adv = new Advertisement();
					adv.setAdvId(rst.getLong("adv_id"));
					adv.setName(rst.getString("name"));
					adv.setEmail(rst.getString("email"));
					adv.setContact(rst.getString("contact"));
					adv.setAddress(rst.getString("address"));
					adv.setLocation(rst.getString("location"));
					adv.setTitle(rst.getString("title"));
					adv.setMake(rst.getString("make"));
					adv.setModel(rst.getString("model"));
					adv.setModelNumber(rst.getString("model_no"));
					adv.setMakeYear(rst.getString("make_year"));
					adv.setRegisteredYear(rst.getString("reg_year"));
					adv.setPrice(rst.getDouble("price"));
					adv.setPhoto1(rst.getBinaryStream("photo1"));
					adv.setPhoto2(rst.getBinaryStream("photo2"));
					adv.setPhoto3(rst.getBinaryStream("photo3"));
					adv.setPhoto4(rst.getBinaryStream("photo4"));
					adv.setAdditionalInfo(rst.getString("additional_info"));
					adv.setApproved(rst.getInt("approved"));
					adv.setPostedDate(rst.getDate("post_dt"));
					adv.setPublishDate(rst.getDate("publish_dt"));
					adv.setCategory(rst.getString("category"));
					adv.setGear(rst.getString("gear"));
					adv.setEngineCapacity(rst.getInt("engine_capacity"));
					adv.setMileage(rst.getInt("mileage"));
					advList.add(adv);
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					con.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return advList;
	}

}
