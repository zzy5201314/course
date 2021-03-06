import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [{
        path: '*',
        redirect: '/login',
    }, {
        path: '/login',
        // 懒加载
        component: () => import('./views/login.vue')
    }, {
        path: '/',
        name: 'admin',
        // 懒加载
        component: () => import('./views/admin.vue'),
        children: [{
            path: 'welcome',
            name: 'welcome',
            component: () => import('./views/admin/welcome.vue')
        },{
            path: 'business/chapter',
            name: 'business/chapter',
            component: () => import('./views/admin/chapter.vue')
        }]
    }]
})