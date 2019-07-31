

module.exports.routes = {

  '/': { 
    view: 'pages/homepage' 
  },
  'GET /allMuseums' :{
    action: 'museum/listAll'
  },
  'POST /picture' : {
    action : 'museum/upload'
  },
  'GET /picture' : {
    action : 'museum/getPic'
  },
  'POST /login' : {
    action : 'user/login'
  },
  'GET /allEvents/:museumId' : {
    action : 'event/listAll'
  }

};
