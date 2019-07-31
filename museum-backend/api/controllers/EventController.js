/**
 * EventController
 *
 * @description :: Server-side actions for handling incoming requests.
 * @help        :: See https://sailsjs.com/docs/concepts/actions
 */

module.exports = {
  
    listAll : async (req, res) => {
        const params = req.allParams()
        if (params.museumId){
            try{
                var events = []
                events = await Event
                    .find({ museum_event_FK : params.museumId})
                    .populate('museum_event_FK')
                const eventsList = []
                Object.entries(events).forEach(element => {
                    var newEvent = 
                        {
                            "id" : element[1].id,
                            "name" : element[1].name,
                            "dateStart": element[1].dateStart,
                            "timeStart" : element[1].timeStart,
                            "description" : element[1].description,
                            "endDate" : element[1].endDate,
                            "endTime" : element[1].endTime,
                            "museumId" : element[1].museum_event_FK.id,
                            "museumName" : element[1].museum_event_FK.name
                        }
                    
                    eventsList.push(newEvent)
                });
                return res.ok(eventsList)
            }catch (e){
                return res.serverError(
                    {
                        error : 400,
                        message : e
                    }
                )
            }
        }else{
            return res.badRequest(
                {
                    error : 300,
                    mensaje: 'No envía ID del museo'
                }
            )
        }
    },

    upload : (req, res) => {
        const opcionesDeCarga = {
            maxBytes : 10000000,
            dirname : __dirname + '/../../files',
        }
        req.file('imagen')
            .upload(
                opcionesDeCarga,
                (error, archivosSubidos) =>{
                    if(error){
                        return res.serverError({
                            error : 500,
                            mensaje : 'Error subiendo archivo de imagen'
                        })
                    }
                    const noExistenArchivos = archivosSubidos.length === 0
                    if(noExistenArchivos){
                        return res.badRequest({
                            error : 400,
                            mensaje : 'No se subió ningún archivo'
                        })
                    }else {
                        Event.update(req.param('id'))
                            .set({
                                picFD: archivosSubidos[0].fd
                            }).exec(function (err){
                                if (err) return res.serverError(err);
                                return res.ok();
                              });                          

                        return res.ok({
                            mensaje : 'ok'
                        })
                    }
                }
            )
    },

    getPic (req, res){
        const opcionesDeDescarga = {
            maxBytes : 10000000,
            dirname : __dirname + '/../../files',
        }
        Event.findOne(req.param('id')).exec(function (err, museum){
          if (err) return res.serverError(err);
          if (!museum) return res.notFound();
      
          if (!museum.picFD) {
            return res.notFound();
          }
          var SkipperDisk = require('skipper-disk');
          var fileAdapter = SkipperDisk(opcionesDeDescarga);
          // Stream the file down
          fileAdapter.read(museum.picFD)
          .on('error', function (err){
            return res.serverError(err);
          })
          .pipe(res);
        });
      }


};

