package cn.lcy.lookfor.service;

import cn.lcy.lookfor.dao.PostReleaseRepository;
import cn.lcy.lookfor.model.PostRelease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PostReleaseService {

    @Autowired
    private PostReleaseRepository postReleaseRepository;

    @Transactional
    public PostRelease addPostRelease(PostRelease postRelease, String postImgUrls) {
        // 添加 identifyId、releaseTime、postImg
        String uuid = UUID.randomUUID().toString().replace("-", "");
        postRelease.setIdentifyId(uuid);
        postRelease.setReleaseTime(new Date(System.currentTimeMillis()));
        postRelease.setPostImgUrls(postImgUrls);
        postRelease.setViewCount(1l);
        postRelease.setUncoverCount(0l);
        postRelease.setSuccessCount(0l);
        postRelease.setPaidReward("0");
        postRelease.setStatus(1);
        return this.postReleaseRepository.save(postRelease);
    }

    @Transactional
    public PostRelease updatePostRelease(PostRelease postRelease) {
        return this.postReleaseRepository.save(postRelease);
    }

    public PostRelease getPostReleaseById(String identifyId) {
        return this.postReleaseRepository.findOne(identifyId);
    }

    public List<PostRelease> getPostReleasesByStatus(int status) {
        return this.postReleaseRepository.findByStatus(status);
    }

    public List<PostRelease> getPostReleasesByTime(Timestamp startDate, Timestamp endDate) {
        return this.postReleaseRepository.findByReleaseTimeBetween(startDate, endDate);
    }

    public List<PostRelease> getPostReleaseByStatusAndTime(int status, Timestamp startDate, Timestamp endDate) {
        return this.postReleaseRepository.findByStatusAndReleaseTimeBetween(status, startDate, endDate);
    }

}
