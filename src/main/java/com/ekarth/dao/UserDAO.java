package com.ekarth.dao;

import com.ekarth.model.User;

/**
 * Created by shiwang on 5/23/17.
 */
public interface UserDAO {
        public void insert(User customer);
        public User findByCustomerId(int custId);
}