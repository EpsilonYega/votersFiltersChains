package api.configs;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CustomAccessDecisionVoter extends AuthenticatedVoter implements AccessDecisionVoter<Object> {

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true; // Возвращает true, если этот Voter поддерживает переданный атрибут
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true; // Возвращает true, если этот Voter поддерживает переданный класс
    }

    @Override
    public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {
        if (authentication == null) {
            return AccessDecisionVoter.ACCESS_DENIED;
        }

        int result = AccessDecisionVoter.ACCESS_ABSTAIN;

        for (ConfigAttribute attribute : attributes) {
            if (this.supports(attribute)) {
                result = AccessDecisionVoter.ACCESS_DENIED;

                // Реализуйте здесь вашу логику принятия решения о доступе на основе переданных параметров
                // Например, проверка ролей пользователя или другие условия

                if (result == AccessDecisionVoter.ACCESS_GRANTED) {
                    return AccessDecisionVoter.ACCESS_GRANTED;
                }
            }
        }

        return result;
    }
}
