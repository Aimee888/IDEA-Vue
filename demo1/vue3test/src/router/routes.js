import LoginPage from '@/views/LoginPage.vue'
import JumpTest from '@/views/JumpTest.vue'
import HomeTest from '@/views/HomeTest.vue'
import AboutTest from "@/views/AboutTest.vue";
import ProFile from "@/views/ProFile.vue";
import Role from "@/views/Role.vue";

const routes = [
    {
        name: 'LoginPage',
        path: '/',
        component: LoginPage
    },
    {
        name: 'JumpTest',
        path: '/JumpTest',
        redirect: '/HomeTest',
        component: JumpTest,
        children: [
            {path: '/HomeTest', name: 'HomeTest', component: HomeTest},
            {path: '/AboutTest', name: 'AboutTest', component: AboutTest},
            {path: '/ProFile', name: 'ProFile', component: ProFile},
            {path: '/Role', name: 'Role', component: Role}
        ],
        props: route => ({param: route.query.param})
    }
];
export default routes
