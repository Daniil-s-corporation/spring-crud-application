package app.service;

import app.dao.UserDao;
import app.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService { // , BeanFactoryPostProcessor, BeanPostProcessor

    private final UserDao<User, Long> userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(User user){
        userDao.save(user);
    }

    public void update(User user){
        userDao.update(user);
    }

    public void delete(Long id){
        userDao.delete(id);
    }

    public User findById(Long id){
        return userDao.findById(id);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }


    //Фаза 0: Подготовка (Еще до рождения бинов)
    //Прежде чем создать хоть один объект, Spring читает аннотации (@Configuration, @Component)
    //и файлы конфигурации. Он создает BeanDefinition — "чертежи" будущих бинов.
    //
    //Интерфейс BeanFactoryPostProcessor
    //Позволяет тебе вмешаться в эти чертежи до того, как будут созданы сами объекты бинов.
//    @Override
//    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
//        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("userServiceImpl");
//        beanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
//   configurableListableBeanFactory.preInstantiateSingletons();
//    }


//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
//    }

//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
//    }
}
