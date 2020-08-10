package cn.lcy.lookfor.service;

import cn.lcy.lookfor.dao.UserRepository;
import cn.lcy.lookfor.model.User;
import cn.lcy.lookfor.neo4j.dao.PostForwardRepository;
import cn.lcy.lookfor.neo4j.dao.UserNodeRepository;
import cn.lcy.lookfor.neo4j.model.PostForward;
import cn.lcy.lookfor.neo4j.model.UserNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostForwardService {

    @Autowired
    private PostForwardRepository postForwardRepository;

    @Autowired
    private UserNodeRepository userNodeRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public PostForward addPostForward(String postIdentifyId, String startUserIdentifyId, String endUserIdentifyId) {
        UserNode startUser = this.userNodeRepository.findByPostIdentifyIdAndUserIdentifyId(postIdentifyId, startUserIdentifyId);
        if (startUser != null) {
            UserNode endUser = new UserNode(postIdentifyId, endUserIdentifyId);
            PostForward postForward = new PostForward(startUser, endUser);
            return this.postForwardRepository.save(postForward);
        } else {
            return null;
        }
    }

    /**
     * @param postIdentifyId
     * @param startUserIdentifyId // root 节点的 identifyId
     * @param endUserIdentifyId
     * @return
     */
    public List<User> getUserForwardPath(String postIdentifyId, String startUserIdentifyId, String endUserIdentifyId) {
        List<UserNode> userNodes = this.userNodeRepository.getUserNodes(postIdentifyId, startUserIdentifyId, endUserIdentifyId);
        List<User> users = new ArrayList<User>();
        User user = null;
        for (UserNode userNode : userNodes) {
            user = this.userRepository.findOne(userNode.getUserIdentifyId());
            users.add(user);
        }
        return users;
    }

}
