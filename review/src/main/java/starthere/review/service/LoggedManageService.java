package starthere.review.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class LoggedManageService {
    private String id = "";

    public boolean logged() {
        if (id.isEmpty())
            return false;
        return true;
    }
    
    public void setId(String id) {
        this.id = id;
    }
}
