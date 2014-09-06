package jxau.spms.tutor.service;

import java.util.List;
import java.util.Map;

import jxau.spms.common.vo.PassModification;
import jxau.spms.tutor.po.TutorBasicInfo;

public interface TutorService{
	public TutorBasicInfo queryTutorByNo(Map<String,Object> params) throws RuntimeException;
	public List<TutorBasicInfo> queryTutors(Map<String,Object> params) throws RuntimeException;
	public void batchAddTutor(List<TutorBasicInfo> tutors) throws RuntimeException;
	public void updateTutor(TutorBasicInfo tutor) throws RuntimeException;
	public String updatePass(PassModification modification) throws RuntimeException;
	public int queryTutorNumber(Map<String, Object> params) throws RuntimeException;
}
