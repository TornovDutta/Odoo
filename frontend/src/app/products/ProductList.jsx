import Link from "next/link";
import React from "react";

const ProductList = () => {
  return (
    <>
      <section className="text-gray-600 body-font">
        <div className="container px-5 py-5 mx-auto">
          <div className="flex flex-col text-center w-full mb-10">
            <h1 className="sm:text-4xl text-3xl font-medium title-font text-gray-900">
              Products
            </h1>
          </div>
          <div className="lg:w-2/3 w-full mx-auto overflow-auto">
            <table className="table-auto w-full text-left whitespace-no-wrap">
              <thead>
                <tr>
                  <th className="px-4 py-3 title-font tracking-wider font-medium text-gray-900 text-sm bg-gray-100 rounded-tl rounded-bl">
                    Name
                  </th>
                  <th className="px-4 py-3 title-font tracking-wider font-medium text-gray-900 text-sm bg-gray-100">
                    SKU
                  </th>
                  <th className="px-4 py-3 title-font tracking-wider font-medium text-gray-900 text-sm bg-gray-100">
                    Catagory
                  </th>
                  <th className="px-4 py-3 title-font tracking-wider font-medium text-gray-900 text-sm bg-gray-100">
                    UOM
                  </th>
                  <th className="px-4 py-3 title-font tracking-wider font-medium text-gray-900 text-sm bg-gray-100">
                    UOM
                  </th>
                  <th className="px-4 py-3 title-font tracking-wider font-medium text-gray-900 text-sm bg-gray-100">
                    LSA
                  </th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td className="px-4 py-3">Premium Rice 1kg</td>
                  <td className="px-4 py-3">PR-001</td>
                  <td className="px-4 py-3">Grocery</td>
                  <td className="px-4 py-3">Kg</td>
                  <td className="px-4 py-3">1</td>
                  <td className="px-4 py-3">20</td>
                </tr>

                <tr>
                  <td className="px-4 py-3">Sunflower Oil 5L</td>
                  <td className="px-4 py-3">SO-005</td>
                  <td className="px-4 py-3">Oil</td>
                  <td className="px-4 py-3">Litre</td>
                  <td className="px-4 py-3">5</td>
                  <td className="px-4 py-3">10</td>
                </tr>

                <tr>
                  <td className="px-4 py-3">Wheat Flour 2kg</td>
                  <td className="px-4 py-3">WF-002</td>
                  <td className="px-4 py-3">Grocery</td>
                  <td className="px-4 py-3">Kg</td>
                  <td className="px-4 py-3">2</td>
                  <td className="px-4 py-3">25</td>
                </tr>

                <tr>
                  <td className="px-4 py-3">Green Tea Pack</td>
                  <td className="px-4 py-3">GT-010</td>
                  <td className="px-4 py-3">Beverages</td>
                  <td className="px-4 py-3">Pack</td>
                  <td className="px-4 py-3">1</td>
                  <td className="px-4 py-3">15</td>
                </tr>

                <tr>
                  <td className="px-4 py-3">Chocolate Cookies</td>
                  <td className="px-4 py-3">CC-021</td>
                  <td className="px-4 py-3">Snacks</td>
                  <td className="px-4 py-3">Box</td>
                  <td className="px-4 py-3">1</td>
                  <td className="px-4 py-3">30</td>
                </tr>

                <tr>
                  <td className="px-4 py-3">Fresh Milk 1L</td>
                  <td className="px-4 py-3">FM-011</td>
                  <td className="px-4 py-3">Dairy</td>
                  <td className="px-4 py-3">Litre</td>
                  <td className="px-4 py-3">1</td>
                  <td className="px-4 py-3">12</td>
                </tr>

                <tr>
                  <td className="px-4 py-3">Butter 500g</td>
                  <td className="px-4 py-3">BT-500</td>
                  <td className="px-4 py-3">Dairy</td>
                  <td className="px-4 py-3">Gram</td>
                  <td className="px-4 py-3">500</td>
                  <td className="px-4 py-3">8</td>
                </tr>

                <tr>
                  <td className="px-4 py-3">Handwash Liquid</td>
                  <td className="px-4 py-3">HW-100</td>
                  <td className="px-4 py-3">Home Care</td>
                  <td className="px-4 py-3">Bottle</td>
                  <td className="px-4 py-3">1</td>
                  <td className="px-4 py-3">18</td>
                </tr>

                <tr>
                  <td className="px-4 py-3">Laundry Detergent</td>
                  <td className="px-4 py-3">LD-750</td>
                  <td className="px-4 py-3">Home Care</td>
                  <td className="px-4 py-3">Gram</td>
                  <td className="px-4 py-3">750</td>
                  <td className="px-4 py-3">20</td>
                </tr>

                <tr>
                  <td className="px-4 py-3">LED Bulb 12W</td>
                  <td className="px-4 py-3">LB-012</td>
                  <td className="px-4 py-3">Electronics</td>
                  <td className="px-4 py-3">Piece</td>
                  <td className="px-4 py-3">1</td>
                  <td className="px-4 py-3">25</td>
                </tr>

                <tr>
                  <td className="px-4 py-3">Shampoo 250ml</td>
                  <td className="px-4 py-3">SH-250</td>
                  <td className="px-4 py-3">Personal Care</td>
                  <td className="px-4 py-3">ml</td>
                  <td className="px-4 py-3">250</td>
                  <td className="px-4 py-3">15</td>
                </tr>

                <tr>
                  <td className="px-4 py-3">Face Wash 100ml</td>
                  <td className="px-4 py-3">FW-100</td>
                  <td className="px-4 py-3">Personal Care</td>
                  <td className="px-4 py-3">ml</td>
                  <td className="px-4 py-3">100</td>
                  <td className="px-4 py-3">10</td>
                </tr>

                <tr>
                  <td className="px-4 py-3">Notebook A4</td>
                  <td className="px-4 py-3">NB-A4</td>
                  <td className="px-4 py-3">Stationary</td>
                  <td className="px-4 py-3">Piece</td>
                  <td className="px-4 py-3">1</td>
                  <td className="px-4 py-3">40</td>
                </tr>

                <tr>
                  <td className="px-4 py-3">Gel Pen Blue</td>
                  <td className="px-4 py-3">GP-BL</td>
                  <td className="px-4 py-3">Stationary</td>
                  <td className="px-4 py-3">Piece</td>
                  <td className="px-4 py-3">1</td>
                  <td className="px-4 py-3">100</td>
                </tr>

                <tr>
                  <td className="px-4 py-3">Power Bank 10000mAh</td>
                  <td className="px-4 py-3">PB-10K</td>
                  <td className="px-4 py-3">Electronics</td>
                  <td className="px-4 py-3">Piece</td>
                  <td className="px-4 py-3">1</td>
                  <td className="px-4 py-3">5</td>
                </tr>

                <tr>
                  <td className="px-4 py-3">USB Cable Type-C</td>
                  <td className="px-4 py-3">USBC-01</td>
                  <td className="px-4 py-3">Accessories</td>
                  <td className="px-4 py-3">Piece</td>
                  <td className="px-4 py-3">1</td>
                  <td className="px-4 py-3">30</td>
                </tr>
              </tbody>
            </table>
          </div>
          <div className="flex pl-4 mt-4 lg:w-2/3 w-full mx-auto">
            <Link
              href="/products/add_product"
              className="text-green-500 inline-flex items-center md:mb-2 lg:mb-0 border-2 px-2 rounded-2xl border-green-500"
            >
              Add Product <b className="ml-2"> +</b>
            </Link>
          </div>
        </div>
      </section>
    </>
  );
};

export default ProductList;
