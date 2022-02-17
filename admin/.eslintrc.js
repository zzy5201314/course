module.exports = {
  root: true,
  env: {
    node: true
  },
  extends: [
    'plugin:vue/essential',
    'eslint:recommended',
  ],
  parserOptions: {
    parser : 'bable-eslint'
  },
  rules: {
    'no-console': process.env.NODE_ENV === 'production' ? 'warn' : 'off',
    'no-debugger': process.env.NODE_ENV === 'production' ? 'warn' : 'off',
    // 'generator-star-spacing': 'off',//禁止空格报错检查
    'no-mixed-spaces-and-tabs': 'off',  //去除空格检查
    'no-undef':'off',
    'vue/no-unused-vars': 'off',
    'vue/require-v-for-key': 'off',
  }
}
