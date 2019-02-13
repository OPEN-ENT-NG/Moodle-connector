import http from "axios";
import {Mix, Selectable, Selection} from 'entcore-toolkit';
import {notify} from "entcore";

export class Folder {
    id : number;
    parent_id : number;
    user_id : string;
    name : string;
    structure_id : string;
    nbItems: number=0;
    subFolders : Folder[];
    printsubfolder: boolean=false;
    toJSON() {
        return {
            parentId : this.parent_id,
            userid : this.user_id,
            name : this.name,
            structureid : this.structure_id,
        }
    }
    async create() {
        try {
            await http.post('/moodle/folder', this.toJSON());
        } catch (e) {
            notify.error("Save function didn't work");
            throw e;
        }
    }
    async countitems () {
        try {
            let countsfolders = await http.get(`/moodle/folder/countsFolders/${this.id}`);
            let countscourses = await http.get(`/moodle/folder/countsCourses/${this.id}`);
            if(countsfolders && countscourses){
                let nbFolders = isNaN(countsfolders.data.count)? 0 : countsfolders.data.count;
                let nbCourses = isNaN(countscourses.data.count)? 0 : countscourses.data.count;
                this.nbItems=nbFolders + nbCourses;
            }

        } catch (e) {
            throw e;
        }
    }
}

export class Folders {
    all: Folder[];
    constructor() {
        this.all = [];
    }
    async sync () {
        try {
            let folders = await http.get(`/moodle/folders`);
            this.all = Mix.castArrayAs(Folder, folders.data);
        } catch (e) {
            throw e;
        }
    }
    getSubFolder(folderId:number): Folder[]  {
        if(this.all){
            return this.all.filter(folder=>folder.parent_id == folderId &&  folder.id != folderId);
        }
        return [];
    }
    getparentFolder(): Folder[]  {
        if(this.all){
            return this.all.filter(folder=>folder.id!=0 && folder.parent_id == folder.id);
        }
        return [];
    }

}