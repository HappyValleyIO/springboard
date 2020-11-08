import {Controller} from '@stimulus/core'
import {DataTable} from "simple-datatables"

/**
 * To use this controller, apply the data-controller attribute to the table itself:
 *
 * <table data-controller="table">
 *   ...
 * </table>
 *
 * Optionally, configure whether the table is searchable by adding `data-table-searchable="true"`
 * Optionally, configure the default page size by adding `data-table-per-page="13"`
 * Optionally, configure whether the user can override page size by adding `data-table-per-page-select="false"`
 * Optionally, configure whether to show the table footer `data-table-footer="true"`
 */
export default class TableController extends Controller {

  connect() {
    const searchable: boolean = this.data.get('searchable') === 'true'
    const perPage: number = parseInt(this.data.get('per-page') || '25')
    const perPageSelect: boolean = this.data.get('per-page-select') !== 'false'
    const footer: boolean = this.data.get('footer') === 'true'

    new DataTable(this.element, {
      searchable: searchable,
      perPageSelect: perPageSelect ? [10, 25, 50, 500] : false,
      perPage: perPage,
      layout: {
        top: '{info}',
        bottom: '{select}{pager}'
      },
      footer: footer
    });
  }
}
