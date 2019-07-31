/**
 * MuseumController
 *
 * @description :: Server-side actions for handling incoming requests.
 * @help        :: See https://sailsjs.com/docs/concepts/actions
 */


module.exports = {
  
    listAll : async (req, res) => {
        try{
            var museums = []
            museums = await Museum.find()
                .populate('museum_information_FK')
                .populate('museum_location_FK')
                .populate('events')
            const museumsList = []
            Object.entries(museums).forEach(element => {
                var newMuseum = 
                    {
                        "id" : element[1].id,
                        "name" : element[1].name,
                        "businessDays": element[1].museum_information_FK.businessDays,
                        "businessHours" : element[1].museum_information_FK.businessHours,
                        "description" : element[1].museum_information_FK.description,
                        "phoneNumber" : element[1].museum_information_FK.phoneNumber,
                        "tags" : element[1].museum_information_FK.tags,
                        "longitude" : element[1].museum_location_FK.longitude,
                        "latitude" : element[1].museum_location_FK.latitude,
                        "events" : element[1].events
                    }
                
                museumsList.push(newMuseum)
            });
            return res.ok(museumsList)
        }catch (e){
            return res.serverError(
                {
                    error : 400,
                    message : e
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
                        var baseUrl = sails.config.custom.baseUrl;
                        Museum.update(req.param('id'))
                            .set({
                                museumPicFD: archivosSubidos[0].fd
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
        Museum.findOne(req.param('id')).exec(function (err, museum){
          if (err) return res.serverError(err);
          if (!museum) return res.notFound();
      
          if (!museum.museumPicFD) {
            return res.notFound();
          }
          var SkipperDisk = require('skipper-disk');
          var fileAdapter = SkipperDisk(opcionesDeDescarga);
          // Stream the file down
          fileAdapter.read(museum.museumPicFD)
          .on('error', function (err){
            return res.serverError(err);
          })
          .pipe(res);
        });
      }
      

};

