package cn.lcy.lookfor.service;

import cn.lcy.lookfor.neo4j.dao.UserNodeRepository;
import cn.lcy.lookfor.neo4j.model.UserNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserNodeService {

    @Autowired
    private UserNodeRepository userNodeRepository;

    @Transactional
    public UserNode addRootUserNode(String postIdentifyId, String userIdentifyId) {
        UserNode userNode = this.userNodeRepository.findByPostIdentifyIdAndUserIdentifyId(postIdentifyId, userIdentifyId);
        if (userNode == null) { // 还没有 root 节点时
            userNode = new UserNode(postIdentifyId, userIdentifyId);
            return this.userNodeRepository.save(userNode);
        }
        return null;
    }

    @Transactional
    public UserNode addUserNode(String postIdentifyId, String userIdentifyId) {
        UserNode userNode = new UserNode(postIdentifyId, userIdentifyId);
        return this.userNodeRepository.save(userNode);
    }

}
