
package com.evan.thinking.spring.geekbang.xmg.spring.ioc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserHolder {

    private User user;

    public UserHolder(User user) {
        this.user = user;
    }

}
