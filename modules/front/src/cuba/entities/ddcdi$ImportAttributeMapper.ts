import { StandardEntity } from "./base/sys$StandardEntity";
import { ImportConfiguration } from "./ddcdi$ImportConfiguration";
import { AttributeMapperMode, AttributeType } from "../enums/enums";
export class ImportAttributeMapper extends StandardEntity {
  static NAME = "ddcdi$ImportAttributeMapper";
  configuration?: ImportConfiguration | null;
  mapperMode?: AttributeMapperMode | null;
  attributeType?: AttributeType | null;
  entityAttribute?: string | null;
  associationLookupAttribute?: string | null;
  fileColumnNumber?: number | null;
  fileColumnAlias?: string | null;
  isRequiredColumn?: boolean | null;
  customAttributeBindScript?: string | null;
}
export type ImportAttributeMapperViewName = "_base" | "_local" | "_minimal";
export type ImportAttributeMapperView<
  V extends ImportAttributeMapperViewName
> = V extends "_base"
  ? Pick<
      ImportAttributeMapper,
      | "id"
      | "mapperMode"
      | "attributeType"
      | "entityAttribute"
      | "associationLookupAttribute"
      | "fileColumnNumber"
      | "fileColumnAlias"
      | "isRequiredColumn"
      | "customAttributeBindScript"
    >
  : V extends "_local"
  ? Pick<
      ImportAttributeMapper,
      | "id"
      | "mapperMode"
      | "attributeType"
      | "entityAttribute"
      | "associationLookupAttribute"
      | "fileColumnNumber"
      | "fileColumnAlias"
      | "isRequiredColumn"
      | "customAttributeBindScript"
    >
  : never;
