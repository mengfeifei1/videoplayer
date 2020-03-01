package com.cakeshop.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.cakeshop.bean.ShoucangBean;
import com.cakeshop.bean.VideoBean;
import com.cakeshop.dao.VideoDao;
@Repository
public class VideoDaoImpl extends BaseDaoImpl implements VideoDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<VideoBean> getVideo(int userId) {
		// TODO Auto-generated method stub
		String hql="from VideoBean where videoUpId=?";
		Query query=getSession().createQuery(hql);
		query.setParameter(0, userId);
		List<VideoBean> videoList=query.list();
		System.out.print("video鐨勬暟閲�"+videoList.size());
		return videoList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShoucangBean> getShoucangVideoId(int userId) {
		// TODO Auto-generated method stub
		String hql="from ShoucangBean where userId=?";
		Query query=getSession().createQuery(hql);
		query.setParameter(0, userId);
		List<ShoucangBean> videoIdList=query.list();
		System.out.print("video鐨勬暟閲�"+videoIdList.size());
		return videoIdList;
	}

	@Override
	public VideoBean getShoucangVideo(int videoId) {
		// TODO Auto-generated method stub
		String hql="from VideoBean where videoId=?";
		Query query=getSession().createQuery(hql);
		query.setParameter(0, videoId);
		VideoBean video=new VideoBean();
		video=(VideoBean) query.list().get(0);
		System.out.print("video鏄�"+video.toString());
		return video;
	}

	//获得全部视频
		@Override
		public List<VideoBean> GetALLVideoList() {
			// TODO Auto-generated method stub
			List<VideoBean> videoList = new ArrayList<>();
			String sql = "select * from video order by video_id desc";
			SQLQuery query = getSession().createSQLQuery(sql).addEntity(VideoBean.class);
			videoList = query.list();
			return videoList;
		}

		//按照点赞升序获得全部视频
		@Override
		public List<VideoBean> GetOrderVideoList() {
			// TODO Auto-generated method stub
			List<VideoBean> videoList = new ArrayList<>();
			String sql = "select * from video order by video_zan_num desc";
			SQLQuery query = getSession().createSQLQuery(sql).addEntity(VideoBean.class);
			videoList = query.list();
			return videoList;
		}

		//按照视频类型获得视频
		@Override
		public List<VideoBean> GetTypeVideoList(String type) {
			// TODO Auto-generated method stub
			List<VideoBean> videoList = new ArrayList<>();
			String sql = "select * from video where video_type=?";
			SQLQuery query = getSession().createSQLQuery(sql).addEntity(VideoBean.class);
			query.setParameter(0, type);
			videoList = query.list();
			return videoList;
		}

		//按照视频标题获得视频
		@Override
		public List<VideoBean> GetTitleVideoList(String title) {
			// TODO Auto-generated method stub
			List<VideoBean> videoList = new ArrayList<>();
			String sql = "select * from video where video_title like ?";
			SQLQuery query = getSession().createSQLQuery(sql).addEntity(VideoBean.class);
			query.setParameter(0, '%'+title+'%');
			videoList = query.list();
			return videoList;
		}

}
