package cn.lcy.lookfor.dao;

import cn.lcy.lookfor.model.PostRelease;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface PostReleaseRepository extends JpaRepository<PostRelease, String> {

    /**
     * 根据指定状态获取招聘帖子
     *
     * @return
     */
    public List<PostRelease> findByStatus(int status);

    /**
     * 查找一定时间范围内的帖子
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public List<PostRelease> findByReleaseTimeBetween(Timestamp startDate, Timestamp endDate);

    /**
     * 查找指定状态且在一定时间范围内的帖子
     *
     * @param status
     * @param startDate
     * @param endDate
     * @return
     */
    public List<PostRelease> findByStatusAndReleaseTimeBetween(int status, Timestamp startDate, Timestamp endDate);

}
