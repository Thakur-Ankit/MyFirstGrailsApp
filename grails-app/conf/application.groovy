

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.useBasicAuth = true
grails.plugin.springsecurity.logout.postOnly = false
//grails.plugin.springsecurity.successHandler.defaultTargetUrl = '/person/index'
grails.plugin.springsecurity.userLookup.userDomainClassName = 'myfirstgrailsapp.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'myfirstgrailsapp.UserRole'
grails.plugin.springsecurity.authority.className = 'myfirstgrailsapp.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/person/**',      filters: 'JOINED_FILTERS,-basicAuthenticationFilter,-basicExceptionTranslationFilter'],
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

